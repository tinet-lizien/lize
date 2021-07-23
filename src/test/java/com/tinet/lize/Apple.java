package com.tinet.lize;

/**
 * @author lize
 * @date 2021年07月03日 21:28
 */
public class Apple {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 颜色
     */
    private String color;
    /**
     * 重量
     */
    private Integer weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Apple(Integer id, String color, Integer weight) {
        this.id = id;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
