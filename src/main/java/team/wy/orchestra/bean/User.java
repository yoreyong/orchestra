package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: User
 * @description: User实体类
 * @author: YORE
 * @date: 2022/7/11
 **/

/**
 * 保存用户的信息
 * 1. 需要添加一个序列化的接口Serializable
 * 2. 私有的属性
 * 3. getter/setter 方法
 * 4. 默认的构造
 */
public class User implements Serializable {

    private Long id;
    private String name;
    private String pwd;
    private Integer state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", state=" + state +
                '}';
    }
}
