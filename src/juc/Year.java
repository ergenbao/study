package juc;



public enum Year {

    Spring(1,"spring"),
    Summer(2,"summer"),
    Autumn(3,"autumn"),
    Winter(4,"winter");

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    Year(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  static String get(int id){
        for (Year ele : Year.values()){
            if(ele.getId() == id) {
                return ele.getName();
            }
        }
        return "";
    }


}
