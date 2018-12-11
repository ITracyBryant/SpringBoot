package io.itracybryant.initializestarter.pojo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @ClassName ItJsonResult
 * @Description 自定义响应数据结构（该类提供给门户网站，iOS，安卓，微信小程序等使用）
 * 前端接受此类数据后需使用本类方法转换成对应的数据类型格式(class, list)
 * 200: 表示成功改变
 * 500: 表示错误
 * 501: bean验证错误，不管多少错误都以map形式返回
 * 502: 拦截器拦截到用户token出错
 * 555: 异常抛出信息
 * @Author Administrator
 * @Date 2018/12/11 14:27
 * @Version 1.0
 */
public class ItJsonResult {
    /**
     * 定义jackson对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * 响应业务状态
     */
    private Integer status;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应中的数据
     */
    private Object data;
    /**
     * 不使用
     */
    private String ok;

    public static ItJsonResult build(Integer status, String msg, Object data) {
        return new ItJsonResult(status, msg, data);
    }

    public static ItJsonResult ok(Object data) {
        return new ItJsonResult(data);
    }

    public static ItJsonResult ok() {
        return new ItJsonResult(null);
    }

    public static ItJsonResult errorMsg(String msg) {
        return new ItJsonResult(500, msg, null);
    }

    public static ItJsonResult errorMap(Object data) {
        return new ItJsonResult(501, "error", data);
    }

    public static ItJsonResult errorTokenMsg(String msg) {
        return new ItJsonResult(502, msg, null);
    }

    public static ItJsonResult errorException(String msg) {
        return new ItJsonResult(555, msg, null);
    }

    public ItJsonResult() {
    }

    public ItJsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ItJsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    /**
     * @Description: 将json结果集转化为ItJsonResult对象
     * 需要转换的对象是一个类
     * @param jsonData
     * @param clazz
     * @return
     */
    public static ItJsonResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ItJsonResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @Description: 没有object对象的转化
     * @param json
     * @return
     */
    public static ItJsonResult format(String json) {
        try {
            return MAPPER.readValue(json, ItJsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @Description: Object是集合转化
     * 需要转换的对象是一个list
     * @param jsonData
     * @param clazz
     * @return
     */
    public static ItJsonResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}

