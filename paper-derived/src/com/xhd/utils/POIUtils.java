package com.xhd.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import com.xhd.common.QuestionTypes;
import com.xhd.entity.QuestionEntity;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * 作者: xhd
 * 创建时间: 2019/8/20 16:39
 * 版本: V1.0
 */
public class POIUtils {
    public static final String OFFICE_EXCEL_XLS = "xls";
    public static final String OFFICE_EXCEL_XLSX = "xlsx";

    /**
     * 读取指定Sheet也的内容
     *
     * @param filepath filepath 文件全路径
     * @param sheetNo  sheet序号,从0开始,如果读取全文sheetNo设置null
     */
    public static List<QuestionEntity> readExcel(String filepath, Integer sheetNo)
            throws EncryptedDocumentException, InvalidFormatException, IOException {
        List<QuestionEntity> questionEntities = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Workbook workbook = getWorkbook(filepath);
        if (workbook != null) {
            if (sheetNo == null) {
                int numberOfSheets = workbook.getNumberOfSheets();
                for (int i = 0; i < numberOfSheets; i++) {
                    Sheet sheet = workbook.getSheetAt(i);
                    if (sheet == null) {
                        continue;
                    }
                    sb.append(readExcelSheet(sheet));
                }
            } else {
                Sheet sheet = workbook.getSheetAt(sheetNo);
                if (sheet != null) {
                    questionEntities = readExcelSheet(sheet);
                }
            }
        }
        return questionEntities;
    }

    /**
     * 根据文件路径获取Workbook对象
     *
     * @param filepath 文件全路径
     */
    public static Workbook getWorkbook(String filepath)
            throws EncryptedDocumentException, InvalidFormatException, IOException {
        InputStream is = null;
        Workbook wb = null;
        if (filepath == null) {
            throw new IllegalArgumentException("文件路径不能为空");
        } else {
            String suffiex = getSuffiex(filepath);
            if (suffiex == null) {
                throw new IllegalArgumentException("文件后缀不能为空");
            }
            if (OFFICE_EXCEL_XLS.equals(suffiex) || OFFICE_EXCEL_XLSX.equals(suffiex)) {
                try {
                    is = new FileInputStream(filepath);
                    wb = WorkbookFactory.create(is);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (wb != null) {
                        wb.close();
                    }
                }
            } else {
                throw new IllegalArgumentException("该文件非Excel文件");
            }
        }
        return wb;
    }

    /**
     * 获取后缀
     *
     * @param filepath filepath 文件全路径
     */
    private static String getSuffiex(String filepath) {
        if (filepath == null) {
            return "";
        }
        int index = filepath.lastIndexOf(".");
        if (index == -1) {
            return "";
        }
        return filepath.substring(index + 1, filepath.length());
    }

    private static List<QuestionEntity> readExcelSheet(Sheet sheet) {
        StringBuilder sb = new StringBuilder();
        List<QuestionEntity> questions = new ArrayList<>();
        if (sheet != null) {
            int rowNos = sheet.getLastRowNum();// 得到excel的总记录条数
            for (int i = 1; i <= rowNos; i++) {// 遍历行
                QuestionEntity question = new QuestionEntity();
                Row row = sheet.getRow(i);
                if (row != null) {
                    //TODO 赋值优化
                    //类型 题干 选项A 选项B 选项C 选项D 选项E 答案 考点 段位 分值
                    int columNos = row.getLastCellNum();// 表头总共的列数
                    //ID 第几行赋值
                    question.setId((long) i);
                    //类型
                    Cell cell1 = row.getCell(0);
                    cell1.setCellType(CellType.STRING);
                    String questionType = cell1.getStringCellValue().trim();
                    question.setQuestionType(questionType);
                    //题干
                    Cell cell2 = row.getCell(1);
                    cell1.setCellType(CellType.STRING);
                    String problem = cell2.getStringCellValue().trim();
                    question.setProblem(problem);
                    //-------------------------------------------------------------------------------
                    if (questionType.equals(QuestionTypes.SINGLE_CHOICE) || questionType.equals(QuestionTypes.MULTIPLE_CHOICE)) {
                        List<String> options = new ArrayList<>();
                        //选项A
                        Cell cell3 = row.getCell(2);
                        String optionA = getOptionString(cell3);
                        if (optionA != null) {
                            options.add(optionA);
                        }
                        //选项B
                        Cell cell4 = row.getCell(3);
                        String optionB = getOptionString(cell4);
                        if (optionB != null) {
                            options.add(optionB);
                        }
                        //选项C
                        Cell cell5 = row.getCell(4);
                        String optionC = getOptionString(cell5);
                        if (optionC != null) {
                            options.add(optionC);
                        }
                        //选项D
                        Cell cell6 = row.getCell(5);
                        String optionD = getOptionString(cell6);
                        if (optionD != null) {
                            options.add(optionD);
                        }
                        //选项E
                        Cell cell7 = row.getCell(6);
                        String optionE = getOptionString(cell7);
                        if (optionE != null) {
                            options.add(optionE);
                        }
                        question.setOptions(options);
                    }
                    //----------------------------------------------------------------------------
                    //答案
                    Cell cell8 = row.getCell(7);
                    cell1.setCellType(CellType.STRING);
                    String answer = cell8.getStringCellValue().trim();
                    question.setAnswer(answer);
                    //考点
                    Cell cell9 = row.getCell(8);
                    cell1.setCellType(CellType.STRING);
                    String testingCentre = cell9.getStringCellValue().trim();
                    question.setTestingCentre(testingCentre);
                    //段位
//                    Cell cell10 = row.getCell(9);
//                    cell1.setCellType(CellType.STRING);
//                    String danGrading = cell10.getStringCellValue().trim();
//                    question.setDanGrading(danGrading);
                    //分值
                    Cell cell11 = row.getCell(10);
                    cell1.setCellType(CellType.STRING);
                    double score = cell11.getNumericCellValue();
                    question.setScore(score);
//                    for (int j = 0; j < columNos; j++) {
//                        Cell cell = row.getCell(j);
//                        if (cell != null) {
//                            cell.setCellType(CellType.STRING);
//                            sb.append(cell.getStringCellValue() + " ");
//                            // System.out.print(cell.getStringCellValue() + " ");
//                        }
//                    }
                    // System.out.println();
                }
                questions.add(question);
            }
        }

        return questions;
    }

    private static String getOptionString(Cell cell) {
        if (cell != null) {
            cell.setCellType(CellType.STRING);
            String option = cell.getStringCellValue().trim();
            if (!option.equals("")) {
                return option;
            }
        }
        return null;
    }
}
