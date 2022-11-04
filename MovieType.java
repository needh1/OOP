

public enum MovieType {
    _2D("2D"),
    _3D("3D");

    private String type;

    MovieType(String type){
        this.type = type;
    }

    public String toString(){
        return type;
    }
}