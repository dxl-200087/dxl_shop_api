package com.fh.dxl_shop_springboot.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;

public class OssFileUtils {
    //保存的地区
    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    //AccessKey的ID
    private static   String accessKeyId = "LTAI4G9TSYwGvW7ZmLUueQMG";
    //AccessKey的secret
    private static  String accessKeySecret = "Qm1lUvJA7cbDQYdhABm2BwhZ0rIbYx";
    //Bucket的名称
    private static String bucket="dxl-file";

    public static String upLoadFile(InputStream isfile,String fileName){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //调用上传方法
        PutObjectResult putObjectResult = ossClient.putObject(bucket, fileName, isfile);
        //释放资源
        ossClient.shutdown();
        //返回文件的存储路径
        return "https://"+bucket+"."+endpoint+"/"+fileName;
    }


}
