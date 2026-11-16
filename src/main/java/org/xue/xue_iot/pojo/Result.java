package org.xue.xue_iot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private Integer code;
    private String message;
    private Object data;

//    public static <E>Result<E> success(E data) {
//        return new Result(0,"操作成功",data);
//    }

    public static Result success() {
        return new Result(0,"操作成功",null);
    }

    public static Result fail(String message) {
        return new Result(1,message,null);
    }

}
