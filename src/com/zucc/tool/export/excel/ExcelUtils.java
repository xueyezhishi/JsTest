package com.zucc.tool.export.excel;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExcelUtils {
    /** 数字格式化 */
    private static NumberFormat format = NumberFormat.getInstance();
    /** 日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);
    /** 列默认宽度 */
    private static final int DEFAUL_COLUMN_WIDTH = 4000;

    /**
     * 1.创建 workbook
     * @return {@link HSSFWorkbook}
     * @Author : ll. create at 2016年4月14日 上午9:28:27
     */
    private HSSFWorkbook getHSSFWorkbook() {
        LOGGER.info("【创建 workbook】");
        return new HSSFWorkbook();
    }

    /**
     * 2.创建 sheet
     * @param hssfWorkbook {@link HSSFWorkbook}
     * @param sheetName sheet 名称
     * @return {@link HSSFSheet}
     * @Author : ll. create at 2016年4月14日 上午9:28:39
     */
    private HSSFSheet getHSSFSheet(HSSFWorkbook hssfWorkbook, String sheetName) {
        LOGGER.info("【创建 sheet】sheetName ： " + sheetName);
        return hssfWorkbook.createSheet(sheetName);
    }
    
    /**
     * 3.写入表头信息
     * @param hssfWorkbook {@link HSSFWorkbook}
     * @param hssfSheet {@link HSSFSheet}
     * @param headers 列标题，数组形式
     * <p>
     * 如{"列标题1@beanFieldName1@columnWidth","列标题2@beanFieldName2@columnWidth","列标题3@beanFieldName3@columnWidth"}
     * </p>
     * <p>
     * 其中参数@columnWidth可选，columnWidth为整型数值
     * </p>
     * @param title 标题
     * @Author : ll. create at 2016年4月14日 上午9:28:39
     */
    private void writeHeader(HSSFWorkbook hssfWorkbook, HSSFSheet hssfSheet, String[] headers,
                             String title) {
        LOGGER.info("【写入表头信息】");

        // 头信息处理
        String[] newHeaders = headersHandler(headers);

        // 初始化标题和表头单元格样式
        HSSFCellStyle titleCellStyle = createTitleCellStyle(hssfWorkbook);
        // 标题栏
        HSSFRow titleRow = hssfSheet.createRow(0);
        titleRow.setHeight((short) 500);
        HSSFCell titleCell = titleRow.createCell(0);
        // 设置标题文本
        titleCell.setCellValue(new HSSFRichTextString(title));
        // 设置单元格样式
        titleCell.setCellStyle(titleCellStyle);

        // 处理单元格合并，四个参数分别是：起始行，终止行，起始行，终止列
        hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, (short) 0,
            (short) (newHeaders.length - 1)));

        // 设置合并后的单元格的样式
        titleRow.createCell(newHeaders.length - 1).setCellStyle(titleCellStyle);

        // 表头
        HSSFRow headRow = hssfSheet.createRow(1);
        headRow.setHeight((short) 500);
        HSSFCell headCell = null;
        String[] headInfo = null;
        // 处理excel表头
        for (int i = 0, len = newHeaders.length; i < len; i++) {
            headInfo = newHeaders[i].split("@");
            headCell = headRow.createCell(i);
            headCell.setCellValue(headInfo[0]);
            headCell.setCellStyle(titleCellStyle);
            // 设置列宽度
            setColumnWidth(i, headInfo, hssfSheet);
        }
    }
    
    /**
     * 头信息校验和处理
     * @param headers 列标题，数组形式
     * <p>
     * 如{"列标题1@beanFieldName1@columnWidth","列标题2@beanFieldName2@columnWidth","列标题3@beanFieldName3@columnWidth"}
     * </p>
     * <p>
     * 其中参数@columnWidth可选，columnWidth为整型数值
     * </p>
     * @return 校验后的头信息
     * @Author : ll. create at 2016年4月14日 上午9:24:48
     */
    private String[] headersHandler(String[] headers) {
        List<String> newHeaders = new ArrayList<String>();
        for (String string : headers) {
            if (StringUtils.isNotBlank(string)) {
                newHeaders.add(string);
            }
        }
        int size = newHeaders.size();

        return newHeaders.toArray(new String[size]);
    }
    
    /**
     * 创建标题和表头单元格样式
     * @param hssfWorkbook {@link HSSFWorkbook}
     * @return {@link HSSFCellStyle}
     * @Author : ll. create at 2016年4月14日 上午9:28:39
     */
    private HSSFCellStyle createTitleCellStyle(HSSFWorkbook hssfWorkbook) {
        LOGGER.info("【创建标题和表头单元格样式】");
        // 单元格的样式
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        // 设置字体样式，改为变粗
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 13);
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        cellStyle.setFont(font);
        // 单元格垂直居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
        // 设置通用的单元格属性
        setCommonCellStyle(cellStyle);
        return cellStyle;
    }
    
    /**
     * 4.写入内容部分
     * 
     * @param hssfWorkbook {@link HSSFWorkbook}
     * @param hssfSheet {@link HSSFSheet}
     * @param headers 列标题，数组形式
     * <p>
     * 如{"列标题1@beanFieldName1@columnWidth","列标题2@beanFieldName2@columnWidth","列标题3@beanFieldName3@columnWidth"}
     * </p>
     * <p>
     * 其中参数@columnWidth可选，columnWidth为整型数值
     * </p>
     * @param dataList 要导出的数据集合
     * @param startIndex 起始行的索引
     * @throws Exception 
     * @Author : ll. create at 2016年4月14日 上午9:28:39
     */
    private void writeContent(HSSFWorkbook hssfWorkbook, HSSFSheet hssfSheet, String[] headers,
                              List<?> dataList, int startIndex) throws Exception {
        LOGGER.info("【写入Excel内容部分】");
        // 2015-8-13 增加，当没有数据的时候，把原来抛异常的方式修改成返回一个只有头信息，没有数据的空Excel
        if (CollectionUtils.isEmpty(dataList)) {
            LOGGER.warn("【没有内容数据】");
            return;
        }
        HSSFRow row = null;
        HSSFCell cell = null;
        // 单元格的值
        Object cellValue = null;
        // 数据写入行索引
        int rownum = startIndex;
        // 单元格样式
        HSSFCellStyle cellStyle = createContentCellStyle(hssfWorkbook);
        // 遍历集合，处理数据
        for (int j = 0, size = dataList.size(); j < size; j++) {
            row = hssfSheet.createRow(rownum);
            for (int i = 0, len = headers.length; i < len; i++) {
                cell = row.createCell(i);
                cellValue = ReflectUtils.getValueOfGetIncludeObjectFeild(dataList.get(j),
                    headers[i].split("@")[1]);
                cellValueHandler(cell, cellValue);
                cell.setCellStyle(cellStyle);
            }
            rownum++;
        }
    }
    
    
    /**
     * 生成Excel的WorkBook，用于导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param headers 列标题，数组形式
     * <p>
     * 如{"列标题1@beanFieldName1@columnWidth","列标题2@beanFieldName2@columnWidth","列标题3@beanFieldName3@columnWidth"}
     * </p>
     * <p>
     * 其中参数@columnWidth可选，columnWidth为整型数值，默认4000
     * </p>
     * @param dataList 要导出数据的集合
     * @throws Exception
     * @Author : ll. create at 2016年4月14日 上午9:28:39
     */
    public static HSSFWorkbook createExcel2Export(String sheetName, String title, String[] headers,
                                                  List<?> dataList) throws Exception {

        if (ArrayUtils.isEmpty(headers)) {
            LOGGER.warn("【表头为空】");
            throw new RuntimeException("表头不能为空");
        }
        LOGGER.info("【生成Excel的WorkBook，用于导出Excel】sheetName : " + sheetName + " , title : " + title
                    + "  , headers : " + Arrays.toString(headers));
        ExcelUtils excelUtils = new ExcelUtils();
        // 1.创建 Workbook
        HSSFWorkbook hssfWorkbook = excelUtils.getHSSFWorkbook();
        // 2.创建 Sheet
        HSSFSheet hssfSheet = excelUtils.getHSSFSheet(hssfWorkbook, sheetName);
        // 3.写入 head
        excelUtils.writeHeader(hssfWorkbook, hssfSheet, headers, title);
        // 4.写入内容
        excelUtils.writeContent(hssfWorkbook, hssfSheet, headers, dataList,2);

        return hssfWorkbook;
    }
    

    
    
    
    
    //以下为工具
    /**
     * 设置列宽度
     * @param i 列的索引号
     * @param headInfo 表头信息，其中包含了用户需要设置的列宽
     * @Author : ll. create at 2016年4月14日 上午9:28:39
     */
    private void setColumnWidth(int i, String[] headInfo, HSSFSheet hssfSheet) {
        if (headInfo.length < 3) {
            // 用户没有设置列宽，使用默认宽度
            hssfSheet.setColumnWidth(i, DEFAUL_COLUMN_WIDTH);
            return;
        }
        if (StringUtils.isBlank(headInfo[2])) {
            // 使用默认宽度
            hssfSheet.setColumnWidth(i, DEFAUL_COLUMN_WIDTH);
            return;
        }
        // 使用用户设置的列宽进行设置
        hssfSheet.setColumnWidth(i, Integer.parseInt(headInfo[2]));
    }
    /**
     * 设置通用的单元格属性
     * @param cellStyle 要设置属性的单元格
     * @Author : ll. create at 2016年4月14日 上午9:28:39
     */
    private void setCommonCellStyle(HSSFCellStyle cellStyle) {
        // 居中
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置边框
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
    }
    
    /**
     * 创建内容单元格样式
     * @param hssfWorkbook {@link HSSFWorkbook}
     * @return {@link HSSFCellStyle}
     * @Author : ll. create at 2016年4月14日 上午9:28:39
     */
    private HSSFCellStyle createContentCellStyle(HSSFWorkbook hssfWorkbook) {
        LOGGER.info("【创建内容单元格样式】");
        // 单元格的样式
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        // 设置字体样式，改为不变粗
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 11);
        cellStyle.setFont(font);
        // 设置单元格自动换行
        cellStyle.setWrapText(true);
        // 单元格垂直居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
        //水平居中
        //        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置通用的单元格属性
        setCommonCellStyle(cellStyle);
        return cellStyle;
    }
    
    /**
     * 单元格写值处理器
     * @param {{@link HSSFCell}
     * @param cellValue 单元格值
     * @Author : ll. create at 2016年4月14日 上午9:28:39
     */
    private void cellValueHandler(HSSFCell cell, Object cellValue) {
        // 2015-8-13 修改，判断cellValue是否为空，否则在cellValue.toString()会出现空指针异常
        if (cellValue == null) {
            cell.setCellValue("");
            return;
        }
        if (cellValue instanceof String) {
            cell.setCellValue((String) cellValue);
        } else if (cellValue instanceof Boolean) {
            cell.setCellValue((Boolean) cellValue);
        } else if (cellValue instanceof Calendar) {
            cell.setCellValue((Calendar) cellValue);
        } else if (cellValue instanceof Double) {
            cell.setCellValue((Double) cellValue);
        } else if (cellValue instanceof Integer || cellValue instanceof Long
                   || cellValue instanceof Short || cellValue instanceof Float) {
            cell.setCellValue((Double.parseDouble(cellValue.toString())));
        } else if (cellValue instanceof HSSFRichTextString) {
            cell.setCellValue((HSSFRichTextString) cellValue);
        }
        cell.setCellValue(cellValue.toString());
    }
    
    
    
    
}