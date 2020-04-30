package com.company;
import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.toolkit.ImageInfo;
import com.company.utils.*;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;

public class Main {

    public static void main(String[] args) {
        // 在线激活SDK，激活之后可离线使用，程序启动激活即可，无需重复调用
        FaceRecognitionUtils.sdkActivation();
        // 初始化引擎
        FaceRecognitionUtils.InitializeTheEngine(DetectMode.ASF_DETECT_MODE_IMAGE, DetectOrient.ASF_OP_0_ONLY,10,32);

        File file1=new File("F:\\电脑壁纸\\宋祖儿\\5c862c467a803.jpg");
        // 图像1信息
        ImageInfo imageInfo1=getRGBData(file1);

        File file2=new File("F:\\电脑壁纸\\宋祖儿\\5c862c467a803.jpg");
        // 图像2信息
        ImageInfo imageInfo2=getRGBData(file2);



        System.out.println("--*--------------------------------【 图像1 】--------------------------------*--"+System.lineSeparator());


        // 创建图像1中的人脸信息对象列表
        List<FaceInfo> faceInfoList1=new ArrayList<>();
        // 检测图像1中人脸
        FaceRecognitionUtils.faceDetection1(imageInfo1,faceInfoList1);
        // 检测图像1中人脸属性
        FaceRecognitionUtils.faceAttributeDetection1(imageInfo1,faceInfoList1);

        /* 图像1中的人脸年龄 */
        {
            // 创建图像1中的人脸年龄列表
            List<AgeInfo> ageInfoList1 = new ArrayList<>();
            // 检测图像1中的人脸年龄列表
            FaceRecognitionUtils.getAgeInfo(ageInfoList1);
            // 将图像1中的年龄列表打印到控制台
            for (int i = 0; i < ageInfoList1.size(); i++) {
                System.out.println("图像1中的第" + (i + 1) + "张人脸的性别为：" + ageInfoList1.get(i).getAge()+System.lineSeparator());
            }
        }

        /* 图像1中的人脸性别 */
        {
            // 创建图像1中的人脸性别列表
            List<GenderInfo> genderInfoList1 = new ArrayList<>();
            // 检测图像1中的人脸性别列表
            FaceRecognitionUtils.getGender(genderInfoList1);
            // 将图像1中的性别列表打印到控制台
            for (int i = 0; i < genderInfoList1.size(); i++) {
                String sex = genderInfoList1.get(i).getGender() == 0 ? "男" : "女";
                System.out.println("图像1中的第" + (i + 1) + "张人脸的性别为：" + sex+System.lineSeparator());
            }
        }

        /* 图像1中的人脸三维角度 */
        {
            // 创建图像1中的人脸三维角度信息列表
            List<Face3DAngle> face3DAngleList1 = new ArrayList<>();
            // 获取图像1中的人脸三维角度信息列表
            FaceRecognitionUtils.getFace3DAngle(face3DAngleList1);
            // 将图像1中的人脸三维角度信息列表打印到控制台
            for (int i = 0; i < face3DAngleList1.size(); i++) {
                System.out.println("图像1中的第" + (i + 1) + "张人脸的3D角度：（俯仰角）" + face3DAngleList1.get(i).getPitch() + ",（横滚角）" +
                        face3DAngleList1.get(i).getRoll() + ",（偏航角）" + face3DAngleList1.get(i).getYaw()+System.lineSeparator());
            }
        }

        /* 图像1中的人脸RGB活体值 */
        {
            // 创建图像1中的RGB活体信息列表
            List<LivenessInfo> livenessInfoList1 = new ArrayList<>();
            // 获取图像1中的RGB活体信息列表
            FaceRecognitionUtils.getLiveness(livenessInfoList1);
            // 将图像1中的RGB活体信息列表打印到控制台
            for (int i = 0; i < livenessInfoList1.size(); i++) {
                System.out.println("图像1中的第" + (i + 1) + "张人脸的RGB活体值：（未知=-1 、非活体=0 、活体=1、超出人脸=-2）" + livenessInfoList1.get(i).getLiveness()+System.lineSeparator());
            }
        }

        /* 图像1中的人脸IR活体值 */
        {
            // 图像1进行IR活体检测（传入分离的图像信息数据）
            FaceRecognitionUtils.detectionLiveness_IR1(file1);
            // 创建图像1中的IR活体信息列表
            List<IrLivenessInfo> irLivenessInfos1 = new ArrayList<>();
            // 获取图像1中的IR活体信息列表
            FaceRecognitionUtils.getIrLiveness(irLivenessInfos1);
            // 将图像1中的IR活体信息列表打印到控制台
            for (int i = 0; i < irLivenessInfos1.size(); i++) {
                System.out.println("图像1中的第" + (i + 1) + "张人脸的IR活体值：（未知=-1 、非活体=0 、活体=1、超出人脸=-2）" + irLivenessInfos1.get(i).getLiveness()+System.lineSeparator());
            }
        }


        System.out.println("--*--------------------------------【 图像2 】--------------------------------*--"+System.lineSeparator());


        // 创建图像2中的人脸信息对象列表
        List<FaceInfo> faceInfoList2=new ArrayList<>();
        // 检测图像2中的人脸
        FaceRecognitionUtils.faceDetection2(imageInfo2,faceInfoList2);
        // 检测图像2中人脸属性
        FaceRecognitionUtils.faceAttributeDetection2(imageInfo2,faceInfoList2);

        /* 图像2中的人脸年龄 */
        {
            // 创建图像2中的人脸年龄列表
            List<AgeInfo> ageInfoList2 = new ArrayList<>();
            // 检测图像2中的人脸年龄列表
            FaceRecognitionUtils.getAgeInfo(ageInfoList2);
            // 将图像2中的年龄列表打印到控制台
            for (int i = 0; i < ageInfoList2.size(); i++) {
                System.out.println("图像2中的第" + (i + 1) + "张人脸的性别为：" + ageInfoList2.get(i).getAge()+System.lineSeparator());
            }
        }

        /* 图像2中的人脸性别 */
        {
            // 创建图像2中的人脸性别列表
            List<GenderInfo> genderInfoList2 = new ArrayList<>();
            // 检测图像2中的人脸性别列表
            FaceRecognitionUtils.getGender(genderInfoList2);
            // 将图像2中的性别列表打印到控制台
            for (int i = 0; i < genderInfoList2.size(); i++) {
                String sex = genderInfoList2.get(i).getGender() == 0 ? "男" : "女";
                System.out.println("图像2中的第" + (i + 1) + "张人脸的性别为：" + sex+System.lineSeparator());
            }
        }

        /* 图像2中的人脸三维角度 */
        {
            // 创建图像2中的人脸三维角度信息列表
            List<Face3DAngle> face3DAngleList2 = new ArrayList<>();
            // 获取图像2中的人脸三维角度信息列表
            FaceRecognitionUtils.getFace3DAngle(face3DAngleList2);
            // 将图像2中的人脸三维角度信息列表打印到控制台
            for (int i = 0; i < face3DAngleList2.size(); i++) {
                System.out.println("图像2中的第" + (i + 1) + "张人脸的3D角度：（俯仰角）" + face3DAngleList2.get(i).getPitch() + ",（横滚角）" +
                        face3DAngleList2.get(i).getRoll() + ",（偏航角）" + face3DAngleList2.get(i).getYaw()+System.lineSeparator());
            }
        }

        /* 图像2中的人脸RGB活体值 */
        {
            // 创建图像2中的RGB活体信息列表
            List<LivenessInfo> livenessInfoList2 = new ArrayList<>();
            // 获取图像2中的RGB活体信息列表
            FaceRecognitionUtils.getLiveness(livenessInfoList2);
            // 将图像2中的RGB活体信息列表打印到控制台
            for (int i = 0; i < livenessInfoList2.size(); i++) {
                System.out.println("图像2中的第" + (i + 1) + "张人脸的RGB活体值：（未知=-1 、非活体=0 、活体=1、超出人脸=-2）" + livenessInfoList2.get(i).getLiveness()+System.lineSeparator());
            }
        }

        /* 图像2中的人脸IR活体值 */
        {
            // 图像1进行IR活体检测（传入分离的图像信息数据）
            FaceRecognitionUtils.detectionLiveness_IR1(file2);
            // 创建图像2中的IR活体信息列表
            List<IrLivenessInfo> irLivenessInfos2 = new ArrayList<>();
            // 获取图像2中的IR活体信息列表
            FaceRecognitionUtils.getIrLiveness(irLivenessInfos2);
            // 将图像2中的IR活体信息列表打印到控制台
            for (int i = 0; i < irLivenessInfos2.size(); i++) {
                System.out.println("图像2中的第" + (i + 1) + "张人脸的IR活体值：（未知=-1 、非活体=0 、活体=1、超出人脸=-2）" + irLivenessInfos2.get(i).getLiveness()+System.lineSeparator());
            }
        }


        System.out.println("--*--------------------------【 图像1 】与【图像2】人脸比对--------------------------*--"+System.lineSeparator());


        /* 比对两张图像中的人脸特征 */
        {
            for (int i = 0; i < faceInfoList1.size(); i++) {
                for (int i1 = 0; i1 < faceInfoList2.size(); i1++) {
                    // 提取图像1中的第n张人脸特征
                    FaceFeature faceFeature1 = FaceRecognitionUtils.faceFeatureExtraction1(imageInfo1, faceInfoList1.get(i));
                    // 提取图像2中的第n张人脸特征
                    FaceFeature faceFeature2 = FaceRecognitionUtils.faceFeatureExtraction1(imageInfo2, faceInfoList2.get(i1));
                    // 人脸特征比对,得到相似度
                    Float similarity = FaceRecognitionUtils.faceFeatureComparison(faceFeature1, faceFeature2);
                    /**
                     * 人脸比对取值范围为[0~1]，推荐阈值如下，高于此阈值的即可判断为
                     * 用于生活照之间的特征比对，推荐阈值0.80
                     * 用于证件照或生活照与证件照之间的特征比对，推荐阈值0.82
                     */
                    if (similarity > 0.8) {
                        BigDecimal bd = BigDecimal.valueOf(similarity * 100).setScale(0, BigDecimal.ROUND_DOWN);
                        System.out.println("图像1中的第" + (i + 1) + "张人脸与图像2中第" + (i1 + 1) + "张人脸匹配成功,相似度高达" + bd + "%！！！"+System.lineSeparator());
                    }
                }
            }
        }


        //销毁SDK引擎
        FaceRecognitionUtils.destroyTheSDKEngine();

    }
}
