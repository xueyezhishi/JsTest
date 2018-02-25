package com.zucc.tool.export.excel;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

public class test3 {
    public static void main(String[] args)throws Exception {
    	HSSFWorkbook wb = exportExcel();
		//输出Excel文件  
		FileOutputStream output;
		try {
			output = new FileOutputStream("d:\\workbook18.xls");
			wb.write(output);  
			output.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	public static HSSFWorkbook exportExcel()throws Exception {
		String[] headers = { "采购日期@1@10000", "采购单号", "试剂代码",
							"试剂名称", "生产厂家", "规格",
							"供应商", "数量", "单位", "单价",
							"主单位数量", "主单位", "金额" };

		try {
			return ExcelUtils.createExcel2Export("采购明细", "采购明细", headers,new ArrayList<Object>());
		} catch (Exception e) {
			throw new RuntimeException("生成Excel表格数据失败", e);
		}
}

}

