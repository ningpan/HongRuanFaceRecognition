package com.company.utils;

import com.arcsoft.face.*;
import com.arcsoft.face.enums.CompareModel;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectModel;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.toolkit.ImageInfo;
import com.arcsoft.face.toolkit.ImageInfoEx;
import com.company.enums.ErrorInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.arcsoft.face.toolkit.ImageFactory.getGrayData;

/**
 * @ClassName : FaceRecognitionUtils
 * @Description : 人脸识别工具类
 * @Author :
 * @Date: 2020-04-14 11:35
 */
public class FaceRecognitionUtils{

    // APP ID，请先在虹软开发者中心注册、认证之后创建应用获取
    private static final String APP_ID="应用的APP ID";
    // SDK KEY，请先在虹软开发者中心注册、认证之后创建应用获取
    private static final String SDK_KEY="应用的APP ID";


    private final static Logger logger= LogManager.getLogger(FaceRecognitionUtils.class.getName());

    //人脸引擎
    private static FaceEngine faceEngine=new FaceEngine();

    //创建引擎功能对象(用于初始化引擎)
    private static FunctionConfiguration functionConfiguration1 = new FunctionConfiguration();

    //创建引擎功能对象(用于人脸检测)
    private static FunctionConfiguration functionConfiguration2 = new FunctionConfiguration();

    static{
        // 初始化引擎功能（用于初始化引擎）
        {
            // 是否支持年龄检测功能
            functionConfiguration1.setSupportAge(true);
            // 是否支持3D检测功能
            functionConfiguration1.setSupportFace3dAngle(true);
            // 是否支持人脸检测功能
            functionConfiguration1.setSupportFaceDetect(true);
            // 是否支持人脸识别功能
            functionConfiguration1.setSupportFaceRecognition(true);
            // 是否支持性别检测功能
            functionConfiguration1.setSupportGender(true);
            // 是否支持RGB活体检测功能
            functionConfiguration1.setSupportLiveness(true);
            // 是否支持IR活体检测功能
            functionConfiguration1.setSupportIRLiveness(true);
        }
        // 初始化引擎功能（用于人脸检测）
        {
            // 是否支持年龄检测功能
            functionConfiguration2.setSupportAge(true);
            // 是否支持3D检测功能
            functionConfiguration2.setSupportFace3dAngle(true);
            // 是否支持性别检测功能
            functionConfiguration2.setSupportGender(true);
            // 是否支持RGB活体检测功能
            functionConfiguration2.setSupportLiveness(true);
        }
    }

    /**
     * 在线激活SDK
     * @return
     */
    public static void sdkActivation(){
        int errorCode=faceEngine.activeOnline(APP_ID,SDK_KEY);
        if(errorCode!= ErrorInfo.MOK.getValue() && errorCode!=ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()){
            // SDK激活失败
            logger.error("在线激活SDK失败！错误码："+errorCode);
        }else{
            // SDK激活成功
            logger.info("在线激活SDK成功！");
        }

    }


    /**
     * 初始化引擎
     * @param detectMode 检测模式（推荐IMAGE 模式）
     * @param detectOrient 人脸检测角度（推荐人脸检测角度，逆时针0度）
     * @param faceMaxNum 人脸检测最大数量（推荐10）
     * @param faceScaleVal 最小人脸比例（VIDEO模式推荐16；IMAGE模式推荐32）
     */
    public static void InitializeTheEngine(DetectMode detectMode, DetectOrient detectOrient, int faceMaxNum, int faceScaleVal){
        // 创建引擎配置类
        EngineConfiguration engineConfiguration=new EngineConfiguration();
        // 设置detectMode参数
        engineConfiguration.setDetectMode(detectMode);
        // 设置detectFaceOrientPriority参数
        engineConfiguration.setDetectFaceOrientPriority(detectOrient);
        // 设置人脸检测最大数量
        engineConfiguration.setDetectFaceMaxNum(faceMaxNum);
        // 设置detectFaceScaleVal参数为：识别的最小人脸比例 = 图片长边 / 人脸框长边的比值
        engineConfiguration.setDetectFaceScaleVal(faceScaleVal);
        // 配置引擎功能
        engineConfiguration.setFunctionConfiguration(functionConfiguration1);

        // 初始化引擎
        int errorCode=faceEngine.init(engineConfiguration);
        if(errorCode != ErrorInfo.MOK.getValue()){
            // 引擎初始化失败
            logger.error("引擎初始化失败！错误码："+errorCode);
        }else{
            // 引擎初始化成功
            logger.info("引擎初始化成功！");
        }
    }


    /**
     * 人脸检测（传入分离的图像信息数据）
     * @param imageInfo 图像信息
     * @param faceInfoList 人脸信息列表
     * @return 检测结果，检测成功或是失败！
     */
    public static boolean faceDetection1(ImageInfo imageInfo,List<FaceInfo> faceInfoList){
        int errorCode = faceEngine.detectFaces(imageInfo.getImageData(),
                imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(),
                faceInfoList);
        if(errorCode != ErrorInfo.MOK.getValue()){
            // 人脸检测失败
            logger.error("人脸检测失败！错误码："+errorCode);
            return false;
        }else{
            // 人脸检测成功
            logger.info("人脸检测成功！");
            return true;
        }
    }


    /**
     * 人脸检测（传入ImageInfoEx图像信息数据）
     * @param imageInfo 图像信息
     * @param faceInfoList 人脸信息列表
     * @return 检测结果，检测成功或是失败！
     */
    public static boolean faceDetection2(ImageInfo imageInfo,List<FaceInfo> faceInfoList){
        ImageInfoEx imageInfoEx = new ImageInfoEx();
        imageInfoEx.setHeight(imageInfo.getHeight());
        imageInfoEx.setWidth(imageInfo.getWidth());
        imageInfoEx.setImageFormat(imageInfo.getImageFormat());
        imageInfoEx.setImageDataPlanes(new byte[][]{imageInfo.getImageData()});
        imageInfoEx.setImageStrides(new int[]{imageInfo.getWidth() * 3});
        int errorCode = faceEngine.detectFaces(imageInfoEx,
                DetectModel.ASF_DETECT_MODEL_RGB, faceInfoList);
        if(errorCode != ErrorInfo.MOK.getValue()){
            // 人脸检测失败
            logger.error("人脸检测失败！错误码："+errorCode);
            return false;
        }else{
            // 人脸检测成功
            logger.info("人脸检测成功！");
            return true;
        }
    }


    /**
     * 人脸特征提取(传入分离的图像信息数据)
     * @param imageInfo 图像信息
     * @param faceInfo 人脸信息
     * @return  人脸特征
     */
    public static FaceFeature faceFeatureExtraction1(ImageInfo imageInfo,FaceInfo faceInfo){
        FaceFeature faceFeature = new FaceFeature();
        int errorCode = faceEngine.extractFaceFeature(imageInfo.getImageData(),
                imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(),
                faceInfo, faceFeature);
        if(errorCode != ErrorInfo.MOK.getValue()){
            // 人脸特征提取失败
            logger.error("人脸特征提取失败！错误码："+errorCode);
            return null;
        }else{
            // 人脸特征提取成功
            logger.info("人脸特征提取成功！");
            return faceFeature;
        }
    }


    /**
     * 人脸特征提取(传入ImageInfoEx图像信息数据)
     * @param imageInfo 图像信息
     * @param faceInfo 人脸信息
     * @return  人脸特征
     */
    public static FaceFeature faceFeatureExtraction2(ImageInfo imageInfo,FaceInfo faceInfo){
        ImageInfoEx imageInfoEx = new ImageInfoEx();
        imageInfoEx.setHeight(imageInfo.getHeight());
        imageInfoEx.setWidth(imageInfo.getWidth());
        imageInfoEx.setImageFormat(imageInfo.getImageFormat());
        imageInfoEx.setImageDataPlanes(new byte[][]{imageInfo.getImageData()});
        imageInfoEx.setImageStrides(new int[]{imageInfo.getWidth() * 3});

        // 创建人脸特征对象
        FaceFeature faceFeature = new FaceFeature();
        int errorCode =  faceEngine.extractFaceFeature(imageInfoEx, faceInfo, faceFeature);
        if(errorCode != ErrorInfo.MOK.getValue()){
            // 人脸特征提取失败
            logger.error("人脸特征提取失败！错误码："+errorCode);
            return null;
        }else{
            // 人脸特征提取成功
            logger.info("人脸特征提取成功！");
            return faceFeature;
        }
    }


    /**
     * 人脸特征比对
     * @param targetFaceFeature 目标人脸特征
     * @param sourceFaceFeature 来源人脸特征
     * @param compareModel 比对模型
     * @return 比对相似度
     */
    public static Float faceFeatureComparison(FaceFeature targetFaceFeature, FaceFeature sourceFaceFeature, CompareModel compareModel){
        // 创建比对相似度对象
        FaceSimilar faceSimilar=new FaceSimilar();
        int errorCode=faceEngine.compareFaceFeature(targetFaceFeature,sourceFaceFeature, compareModel,faceSimilar);
        if(errorCode != ErrorInfo.MOK.getValue()){
            // 人脸特征比对失败
            logger.error("人脸特征比对失败！错误码："+errorCode);
            return null;
        }else{
            // 人脸特征比对成功
            logger.info("人脸特征比对成功！");
            return faceSimilar.getScore();
        }
    }


    /**
     * 人脸特征比对（默认LIFE_PHOTO比对模型）
     * @param targetFaceFeature 目标人脸特征
     * @param sourceFaceFeature 来源人脸特征
     * @return 比对相似度
     */
    public static Float faceFeatureComparison(FaceFeature targetFaceFeature, FaceFeature sourceFaceFeature){
        // 创建比对相似度对象
        FaceSimilar faceSimilar=new FaceSimilar();
        int errorCode = faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature,
                faceSimilar);
        if(errorCode != ErrorInfo.MOK.getValue()){
            // 人脸特征比对失败
            logger.error("人脸特征比对失败！错误码："+errorCode);
            return null;
        }else{
            // 人脸特征比对成功
            logger.info("人脸特征比对成功！");
            return faceSimilar.getScore();
        }
    }


    /**
     * 人脸属性检测（传入分离的图像信息数据）
     * @param imageInfo 图像信息
     * @param faceInfoList 人脸信息列表
     * @return 检测结果，检测成功或是失败！
     */
    public static boolean faceAttributeDetection1(ImageInfo imageInfo,List<FaceInfo> faceInfoList){
        int errorCode = faceEngine.process(imageInfo.getImageData(), imageInfo.getWidth(),
                imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList, functionConfiguration2);
        if(errorCode != ErrorInfo.MOK.getValue()){
            // 人脸属性检测失败
            logger.error("人脸属性检测失败！错误码："+errorCode);
            return false;
        }else{
            // 人脸属性检测成功
            logger.info("人脸属性检测成功！");
            return true;
        }
    }


    /**
     * 人脸属性检测（传入ImageInfoEx图像信息数据）
     * @param imageInfo 图像信息
     * @param faceInfoList 人脸信息列表
     * @return 检测结果，检测成功或是失败！
     */
    public static boolean faceAttributeDetection2(ImageInfo imageInfo,List<FaceInfo> faceInfoList){
        ImageInfoEx imageInfoEx = new ImageInfoEx();
        imageInfoEx.setHeight(imageInfo.getHeight());
        imageInfoEx.setWidth(imageInfo.getWidth());
        imageInfoEx.setImageFormat(imageInfo.getImageFormat());
        imageInfoEx.setImageDataPlanes(new byte[][]{imageInfo.getImageData()});
        imageInfoEx.setImageStrides(new int[]{imageInfo.getWidth() * 3});
        int errorCode = faceEngine.process(imageInfoEx, faceInfoList,
                functionConfiguration2);
        if(errorCode != ErrorInfo.MOK.getValue()){
            // 人脸属性检测失败
            logger.error("人脸属性检测失败！错误码："+errorCode);
            return false;
        }else{
            // 人脸属性检测成功
            logger.info("人脸属性检测成功！");
            return true;
        }
    }


    /**
     * 获取年龄信息
     * 注意：人脸属性检测之后方可调用
     * @return 获取结果，获取失败或是成功!
     */
    public static boolean getAgeInfo(List<AgeInfo> ageInfoList){
        int errorCode = faceEngine.getAge(ageInfoList);
        if(errorCode!=ErrorInfo.MOK.getValue()){
            // 获取年龄信息失败
            logger.error("获取年龄信息失败！错误码："+errorCode);
            return false;
        }else{
            // 已成功获取年龄信息
            logger.info("已成功获取年龄信息！");
            return true;
        }
    }


    /**
     * 获取性别（0为男性，1为女性。）
     * 注意：人脸属性检测之后方可调用
     * @return 获取结果，获取失败或是成功!
     */
    public static boolean getGender(List<GenderInfo> genderInfoList){
        // 性别检测
        int errorCode = faceEngine.getGender(genderInfoList);
        if(errorCode!=ErrorInfo.MOK.getValue()){
            // 获取性别失败
            logger.error("获取性别失败！错误码："+errorCode);
            return false;
        }else{
            // 已成功获取年龄信息
            logger.info("已成功获取性别！");
            return true;
        }
    }


    /**
     * 获取人脸三维角度信息
     * 人脸3D角度：俯仰角（pitch）， 横滚角（roll）， 偏航角（yaw）。
     * 注意：人脸属性检测之后方可调用
     * @return 获取结果，获取失败或是成功!
     */
    public static boolean getFace3DAngle(List<Face3DAngle> face3DAngleList){
        // 人脸三维角度检测
        int errorCode = faceEngine.getFace3DAngle(face3DAngleList);
        if(errorCode!=ErrorInfo.MOK.getValue()){
            // 获取人脸三维角度信息失败
            logger.error("获取人脸三维角度信息失败！错误码："+errorCode);
            return false;
        }else{
            // 已成功获取人脸三维角度信息
            logger.info("已成功获取人脸三维角度信息！");
            return true;
        }
    }


    /**
     * 获取RGB活体信息
     * RGB活体值，未知=-1 、非活体=0 、活体=1、超出人脸=-2
     * 注意：人脸属性检测之后方可调用
     * @return 获取结果，获取失败或是成功!
     */
    public static boolean getLiveness(List<LivenessInfo> livenessInfoList){
        // RGB活体检测
        int errorCode = faceEngine.getLiveness(livenessInfoList);
        if(errorCode!=ErrorInfo.MOK.getValue()){
            // 获取RGB活体信息失败
            logger.error("获取RGB活体信息失败！错误码："+errorCode);
            return false;
        }else{
            // 已成功获取RGB活体信息
            logger.info("已成功获取RGB活体信息！");
            return true;
        }
    }


    /**
     * IR活体检测（传入分离的图像信息数据）
     * 注意：
     *     引擎需要支持IR活体检测功能
     * @return 检测结果，检测成功或是失败！
     */
    public static boolean detectionLiveness_IR1(File file){
        // 创建图像信息
        ImageInfo imageInfoGray = getGrayData(file);
        // 创建人脸信息列表
        List<FaceInfo> faceInfoListGray = new ArrayList<FaceInfo>();
        // 人脸检测（传入分离的图像信息数据）
        int errorCode1 = faceEngine.detectFaces(imageInfoGray.getImageData(),
                imageInfoGray.getWidth(), imageInfoGray.getHeight(),
                imageInfoGray.getImageFormat(), faceInfoListGray);
        // 创建引擎功能实例对象
        FunctionConfiguration configuration = new FunctionConfiguration();
        // 设置引擎支持IR活体检测
        configuration.setSupportIRLiveness(true);
        // IR活体检测
        int errorCode2 = faceEngine.processIr(imageInfoGray.getImageData(),
                imageInfoGray.getWidth(), imageInfoGray.getHeight(),
                imageInfoGray.getImageFormat(), faceInfoListGray, configuration);
        if(errorCode1!=ErrorInfo.MOK.getValue() || errorCode2!=ErrorInfo.MOK.getValue()){
            String errorCode=errorCode1==0?errorCode2+"":errorCode1+"";
            // IR活体检测失败
            logger.error("IR活体检测失败！错误码："+errorCode);
            return false;
        }else{
            // IR活体检测成功
            logger.info("IR活体检测成功！");
            return true;
        }
    }


    /**
     * IR活体检测（传入ImageInfoEx图像信息数据）
     * 注意：
     *     引擎需要支持年龄检测功能
     * @param imageInfo 图像信息
     * @return 检测结果，检测成功或是失败！
     */
    public static boolean detectionLiveness_IR2(ImageInfo imageInfo){
        ImageInfoEx imageInfoEx = new ImageInfoEx();
        imageInfoEx.setHeight(imageInfo.getHeight());
        imageInfoEx.setWidth(imageInfo.getWidth());
        imageInfoEx.setImageFormat(imageInfo.getImageFormat());
        imageInfoEx.setImageDataPlanes(new byte[][]{imageInfo.getImageData()});
        imageInfoEx.setImageStrides(new int[]{imageInfo.getWidth() * 3});
        List<FaceInfo> faceInfoList1 = new ArrayList<>();
        int errorCode1 = faceEngine.detectFaces(imageInfoEx,
                DetectModel.ASF_DETECT_MODEL_RGB, faceInfoList1);
        FunctionConfiguration fun = new FunctionConfiguration();
        fun.setSupportAge(true);
        int errorCode2 = faceEngine.processIr(imageInfoEx, faceInfoList1,
                fun);
        if(errorCode1!=ErrorInfo.MOK.getValue() || errorCode2!=ErrorInfo.MOK.getValue()){
            String errorCode=errorCode1==0?errorCode2+"":errorCode1+"";
            // IR活体检测失败
            logger.error("IR活体检测失败！错误码："+errorCode);
            return false;
        }else{
            // IR活体检测成功
            logger.info("IR活体检测成功！");
            return true;
        }
    }


    /**
     * 获取IR活体信息
     * IR活体值，未知=-1 、非活体=0 、活体=1、超出人脸=-2
     * @return 获取结果，获取失败或是成功!
     */
    public static boolean getIrLiveness(List<IrLivenessInfo> irLivenessInfo){
        // IR活体检测
        int errorCode = faceEngine.getLivenessIr(irLivenessInfo);
        if(errorCode!=ErrorInfo.MOK.getValue()){
            // 获取IR活体信息失败
            logger.error("获取IR活体信息失败！错误码："+errorCode);
            return false;
        }else{
            // 已成功获取IR活体信息
            logger.info("已成功获取IR活体信息！");
            return true;
        }
    }


    /**
     * 销毁SDK引擎
     */
    public static void destroyTheSDKEngine(){
        int errorCode = faceEngine.unInit();
        if(errorCode!=ErrorInfo.MOK.getValue()){
            // 销毁SDK引擎失败
            logger.error("销毁SDK引擎失败！错误码："+errorCode);
        }else{
            // 销毁SDK引擎成功
            logger.info("销毁SDK引擎成功！");
        }
    }

}
