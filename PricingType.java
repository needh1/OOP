public enum PricingType
{
    STUDENT_2D_STANDARD("Student, 2D, Standard"),
    STUDENT_2D_PREMIUM("Student, 2D, Premium"),
    STUDENT_3D_STANDARD("Student, 3D, Standard"),
    STUDENT_3D_PREMIUM("Student, 3D, Premium"),

    SENIOR_2D_STANDARD("Senior, 2D, Standard"),
    SENIOR_2D_PREMIUM("Senior, 2D, Premium"),
    SENIOR_3D_STANDARD("Senior, 3D, Standard"),
    SENIOR_3D_PREMIUM("Senior, 3D, Premium"),
    
    NORMAL_2D_STANDARD("Normal, 2D, Standard"),
    NORMAL_2D_PREMIUM("Normal, 2D, Premium"),
    NORMAL_3D_STANDARD("Normal, 3D, Standard"),
    NORMAL_3D_PREMIUM("Normal, 3D, Premium"),
    
    WEEKEND_2D_STANDARD("Weekend/Holiday, 2D, Standard"),
    WEEKEND_2D_PREMIUM("Weekend/Holiday, 2D, Premium"),
    WEEKEND_3D_STANDARD("Weekend/Holiday, 3D, Standard"),
    WEEKEND_3D_PREMIUM("Weekend/Holiday, 3D, Premium");

    private final String type;

    private PricingType(String type) {
        this.type = type;
    }

    public String toString(){
        return type;
    }
}