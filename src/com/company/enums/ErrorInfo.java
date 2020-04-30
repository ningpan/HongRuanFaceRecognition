package com.company.enums;

/**
 * @EnumName : ErrorInfo
 * @Description : 错误码
 * @Author : np
 * @Date: 2020-04-14 11:49
 */
public enum ErrorInfo {

    /**
     * 成功
     */
    MOK("0x0",0),

    /**
     * 错误原因不明
     */
    MERR_UNKNOWN("0x1",1),

    /**
     * 无效的参数
     */
    MERR_INVALID_PARAM("0x2",2),

    /**
     * 引擎不支持
     */
    MERR_UNSUPPORTED("0x3",3),

    /**86020
     * 内存不足
     */
    MERR_NO_MEMORY("0x4",4),

    /**
     * 状态错误
     */
    MERR_BAD_STATE("0x5",5),

    /**
     * 用户取消相关操作
     */
    MERR_USER_CANCEL("0x6",6),

    /**
     * 操作时间过期
     */
    MERR_EXPIRED("0x7",7),

    /**
     * 用户暂停操作
     */
    MERR_USER_PAUSE("0x8",8),

    /**
     * 缓冲上溢
     */
    MERR_BUFFER_OVERFLOW("0x9", 9),

    /**
     * 缓冲下溢
     */
    MERR_BUFFER_UNDERFLOW("0xA",10),

    /**
     * 存贮空间不足
     */
    MERR_NO_DISKSPACE("0xB",11),

    /**
     * 组件不存在
     */
    MERR_COMPONENT_NOT_EXIST("0xC",12),

    /**
     * 全局数据不存在
     */
    MERR_GLOBAL_DATA_NOT_EXIST("0xD",13),

    /**
     * 无效的AppId
     */
    MERR_FSDK_INVALID_APP_ID("0x7001",28673),

    /**
     * 无效的SDKkey
     */
    MERR_FSDK_INVALID_SDK_ID("0x7002",28674),

    /**
     * AppId和SDKKey不匹配
     */
    MERR_FSDK_INVALID_ID_PAIR("0x7003",28675),

    /**
     * SDKKey和使用的SDK不匹配,请检查入参
     */
    MERR_FSDK_MISMATCH_ID_AND_SDK("0x7004",28676),

    /**
     * 系统版本不被当前SDK所支持
     */
    MERR_FSDK_SYSTEM_VERSION_UNSUPPORTED("0x7005",28677),

    /**
     * SDK有效期过期，需要重新下载更新
     */
    MERR_FSDK_LICENCE_EXPIRED("0x7006",28678),

    /**
     * 无效的输入内存
     */
    MERR_FSDK_FR_INVALID_MEMORY_INFO("0x12001",73729),

    /**
     * 无效的输入图像参数
     */
    MERR_FSDK_FR_INVALID_IMAGE_INFO("0x12002",73730),

    /**
     * 无效的脸部信息
     */
    MERR_FSDK_FR_INVALID_FACE_INFO("0x12003",73731),

    /**
     * 当前设备无GPU可用
     */
    MERR_FSDK_FR_NO_GPU_AVAILABLE("0x12004",73732),

    /**
     * 待比较的两个人脸特征的版本不一致
     */
    MERR_FSDK_FR_MISMATCHED_FEATURE_LEVEL("0x12005",73733),

    /**
     * 人脸特征检测错误未知
     */
    MERR_FSDK_FACEFEATURE_UNKNOWN("0x14001",81921),

    /**
     * 人脸特征检测内存错误
     */
    MERR_FSDK_FACEFEATURE_MEMORY("0x14002",81922),

    /**
     * 人脸特征检测格式错误
     */
    MERR_FSDK_FACEFEATURE_INVALID_FORMAT("0x14003",81923),

    /**
     * 人脸特征检测参数错误
     */
    MERR_FSDK_FACEFEATURE_INVALID_PARAM("0x14004",81924),

    /**
     * 人脸特征检测结果置信度低
     */
    MERR_FSDK_FACEFEATURE_LOW_CONFIDENCE_LEVEL("0x14005",81925),

    /**
     * Engine不支持的检测属性
     */
    MERR_ASF_EX_FEATURE_UNSUPPORTED_ON_INIT("0x15001",86017),

    /**
     * 需要检测的属性未初始化
     */
    MERR_ASF_EX_FEATURE_UNINITED("0x15002",86018),

    /**
     * 待获取的属性未在process中处理过
     */
    MERR_ASF_EX_FEATURE_UNPROCESSED("0x15003",86019),

    /**
     * PROCESS不支持的检测属性，例如FR，有自己独立的处理函数
     */
    MERR_ASF_EX_FEATURE_UNSUPPORTED_ON_PROCESS("0x15004",86020),

    /**
     * 无效的输入图像
     */
    MERR_ASF_EX_INVALID_IMAGE_INFO("0x15005",86021),

    /**
     * 无效的脸部信息
     */
    MERR_ASF_EX_INVALID_FACE_INFO("0x15006",86022),

    /**
     * SDK激活失败，请打开读写权限
     */
    MERR_ASF_ACTIVATION_FAIL("0x16001",90113),

    /**
     * SDK已激活
     */
    MERR_ASF_ALREADY_ACTIVATED("0x16002",90114),

    /**
     * SDK未激活
     */
    MERR_ASF_NOT_ACTIVATED("0x16003",90115),

    /**
     * detectFaceScaleVal不支持
     */
    MERR_ASF_SCALE_NOT_SUPPORT("0x16004",90116),

    /**
     * 激活文件与SDK类型不匹配，请确认使用的sdk
     */
    MERR_ASF_ACTIVEFILE_SDKTYPE_MISMATCH("0x16005",90117),

    /**
     * 设备不匹配
     */
    MERR_ASF_DEVICE_MISMATCH("0x16006",90118),

    /**
     * 唯一标识不合法错误码名
     */
    MERR_ASF_UNIQUE_IDENTIFIER_ILLEGAL("0x16007",90119),

    /**
     * 参数为空
     */
    MERR_ASF_PARAM_NULL("0x16008",90120),

    /**
     * 活体已过期
     */
    MERR_ASF_LIVENESS_EXPIRED("0x16009",90121),

    /**
     * 版本不支持
     */
    MERR_ASF_VERSION_NOT_SUPPORT("0x1600A",90122),

    /**
     * 签名错误
     */
    MERR_ASF_SIGN_ERROR("0x1600B",90123),

    /**
     * 激活信息保存异常
     */
    MERR_ASF_DATABASE_ERROR("0x1600C",90124),

    /**
     * 唯一标识符校验失败
     */
    MERR_ASF_UNIQUE_CHECKOUT_FAIL("0x1600D",90125),

    /**
     * 颜色空间不支持
     */
    MERR_ASF_COLOR_SPACE_NOT_SUPPORT("0x1600E",90126),

    /**
     * 图片宽高不支持，宽度需四字节对齐
     */
    MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT("0x1600F",90127),

    /**
     * android.permission.READ_PHONE_STATE权限被拒绝
     */
    MERR_ASF_READ_PHONE_STATE_DENIED("0x16010",90128),

    /**
     * 激活数据被破坏,请删除激活文件，重新进行激活
     */
    MERR_ASF_ACTIVATION_DATA_DESTROYED("0x16011",90129),

    /**
     * 服务端未知错误
     */
    MERR_ASF_SERVER_UNKNOWN_ERROR("0x16012",90130),

    /**
     * INTERNET权限被拒绝
     */
    MERR_ASF_INTERNET_DENIED("0x16013",90131),

    /**
     * 激活文件与SDK版本不匹配,请重新激活
     */
    MERR_ASF_ACTIVEFILE_SDK_MISMATCH("0x16014",90132),

    /**
     * 设备信息太少，不足以生成设备指纹
     */
    MERR_ASF_DEVICEINFO_LESS("0x16015",90133),

    /**
     * 客户端时间与服务器时间（即北京时间）前后相差在30分钟以上
     */
    MERR_ASF_LOCAL_TIME_NOT_CALIBRATED("0x16016",90134),

    /**
     * 数据校验异常
     */
    MERR_ASF_APPID_DATA_DECRYPT("0x16017",90135),

    /**
     * 传入的AppId和AppKey与使用的SDK版本不一致
     */
    MERR_ASF_APPID_APPKEY_SDK_MISMATCH("0x16018",90136),

    /**
     * 短时间大量请求会被禁止请求,30分钟之后解封
     */
    MERR_ASF_NO_REQUEST("0x16019",90137),

    /**
     * 激活文件不存在
     */
    MERR_ASF_ACTIVE_FILE_NO_EXIST("0x1601A",90138),

    /**
     * 图像格式不支持，请查看对应接口注释，使用当前支持的图像格式
     */
    MERR_ASF_IMAGE_FORMAT_UNSUPPORT("0x1601B",90139),

    /**
     * 当前设备时间不正确，请调整设备时间
     */
    MERR_ASF_CURRENT_DEVICE_TIME_INCORRECT("0x1601C",90140),

    /**
     * 无法解析主机地址
     */
    MERR_ASF_NETWORK_COULDNT_RESOLVE_HOST("0x17001",94209),

    /**
     * 无法连接服务器
     */
    MERR_ASF_NETWORK_COULDNT_CONNECT_SERVER("0x17002",94210),

    /**
     * 网络连接超时
     */
    MERR_ASF_NETWORK_CONNECT_TIMEOUT("0x17003",94211),

    /**
     * 网络未知错误
     */
    MERR_ASF_NETWORK_UNKNOWN_ERROR("0x17004",94212);

    ErrorInfo(String hex,int value) {
        this.value = value;
        this.hex = hex;
    }

    /**
     * 十进制
     */
    private int value;

    /**
     * 十六进制
     */
    private String hex;

    public int getValue() {
        return this.value;
    }

    public String getHex() {
        return hex;
    }

    public static ErrorInfo getValidEnum(int value) {
        ErrorInfo[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ErrorInfo errorInfo = var1[var3];
            if (errorInfo.getValue() == value) {
                return errorInfo;
            }
        }

        return MERR_UNKNOWN;
    }

}
