package com.xhd.service;

import com.xhd.common.QuestionTypes;
import com.xhd.entity.QuestionEntity;
import com.xhd.utils.ArithmeticUtils;
import com.xhd.utils.FileUtils;
import com.xhd.utils.POIUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 作者: xhd
 * 创建时间: 2019/8/21 9:40
 * 版本: V1.0
 */
public class AssemblyPaperService {

    private static List<QuestionEntity> classify(List<QuestionEntity> questionEntities, String type, Properties paramConf) {
        List<QuestionEntity> finalQuestion = new ArrayList<>();
        String param = paramConf.getProperty(type);
        if (param != null && !param.equals("")) {
            List<QuestionEntity> questionEntitiesClassify = new ArrayList<>();
            if (questionEntities != null && questionEntities.size() > 0) {
                for (QuestionEntity questionEntity : questionEntities) {
                    if (questionEntity.getQuestionType().equals(type)) {
                        questionEntitiesClassify.add(questionEntity);
                    }
                }
            }
            if (questionEntitiesClassify != null && questionEntitiesClassify.size() > 0) {
                //考点及数量
                String[] strs = param.split(",");
                for (String str : strs) {
                    String testingCentre = str.split("-")[0];
                    String count = str.split("-")[1];
                    List<QuestionEntity> questionEntitiesCentre = new ArrayList<>();
                    for (QuestionEntity questionEntity : questionEntitiesClassify) {
                        if (questionEntity.getTestingCentre().equals(testingCentre)) {
                            questionEntitiesCentre.add(questionEntity);
                        }
                    }
                    if (questionEntitiesCentre != null && questionEntitiesCentre.size() > 0) {
                        int[] nums = ArithmeticUtils.randomArray(0, questionEntitiesCentre.size() - 1, Integer.parseInt(count));
                        if (nums != null) {
                            for (int num : nums) {
                                finalQuestion.add(questionEntitiesCentre.get(num));
                            }
                        }
                    }
                }
            }
            return finalQuestion;
        }
        return null;
    }

    public void assembly(Properties paramConf) throws Exception {
        String filePath = paramConf.getProperty("filePath");
        if (filePath.equals("") || filePath == null) {
            System.out.println("文件路径不正确");
        }
        List<QuestionEntity> questionEntities = POIUtils.readExcel(filePath, 0);
        //单选题
        List<QuestionEntity> danxuan = classify(questionEntities, QuestionTypes.SINGLE_CHOICE, paramConf);
        //多选题
        List<QuestionEntity> duoxuan = classify(questionEntities, QuestionTypes.MULTIPLE_CHOICE, paramConf);
        //判断题
        List<QuestionEntity> panduan = classify(questionEntities, QuestionTypes.TRUE_OR_FALSE, paramConf);
        //填空题
        List<QuestionEntity> tiankong = classify(questionEntities, QuestionTypes.GAP_FILLING, paramConf);
        //简答题
        List<QuestionEntity> jiandan = classify(questionEntities, QuestionTypes.SIMPLE_QUESTION, paramConf);
        String fileName = paramConf.getProperty("导出文件名");
        if (fileName.equals("") || fileName == null) {
            System.out.println("请输入导出文件名");
        }
        //TODO 优化拼接
        StringBuilder sb = new StringBuilder();
        FileUtils.createFile(System.getProperty("user.dir") + fileName + ".txt");
        if (danxuan != null && danxuan.size() > 0) {
            sb.append(QuestionTypes.SINGLE_CHOICE + "\r\n" + "\n");
            for (int i = 0; i < danxuan.size(); i++) {
                sb.append((i + 1));
                sb.append("." + "(" + danxuan.get(i).getScore() + "分) ");
                sb.append(danxuan.get(i).getProblem() + "\r\n");
                String str = getChoice(danxuan.get(i).getOptions());
                sb.append(str);
                sb.append("\n");

            }

        }

        if (duoxuan != null && duoxuan.size() > 0) {
            sb.append(QuestionTypes.MULTIPLE_CHOICE + "\r\n" + "\n");
            for (int i = 0; i < duoxuan.size(); i++){
                sb.append((i + 1));
                sb.append("." + "(" + duoxuan.get(i).getScore() + "分) ");
                sb.append(duoxuan.get(i).getProblem() + "\r\n");
                String str = getChoice(duoxuan.get(i).getOptions());
                sb.append(str);
                sb.append("\n");
            }
        }
        sb.append(getNotChoice(panduan));
        sb.append(getNotChoice(tiankong));
        sb.append(getNotChoice(jiandan));
        System.out.println(sb);

        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(System.getProperty("user.dir") + "/"+fileName + ".txt", true);
            fwriter.write(sb.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }
    public static String getNotChoice(List<QuestionEntity> questionEntityList){
        String str="";
        if(questionEntityList!=null&&questionEntityList.size()>0){
            str+=questionEntityList.get(0).getQuestionType() + "\r\n" + "\n";
            for(int i = 0; i < questionEntityList.size(); i++){
                str+=(i + 1);
                str+="." + "(" + questionEntityList.get(i).getScore() + "分) ";
                str+=questionEntityList.get(i).getProblem() + "\r\n";
                str+="\n";
            }
            return str;
        }
        return str;
    }

    private static String getChoice(List<String> options) {
        String str = "";
        if (options != null && options.size() > 0) {
            for (int i = 0; i < options.size(); i++) {
                switch (i) {
                    case 0:
                        str += "A.";
                        break;
                    case 1:
                        str += "B.";
                        break;
                    case 2:
                        str += "C.";
                        break;
                    case 3:
                        str += "D.";
                        break;
                    case 4:
                        str += "E.";
                        break;
                }
                str += options.get(i);
                str += "\r\n";
            }
            return str;
        }
        return "";
    }
}
