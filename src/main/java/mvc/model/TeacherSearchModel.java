package mvc.model;

import org.springframework.stereotype.Component;

@Component
public class TeacherSearchModel {
    private String lastName;

    public TeacherSearchModel(){}
    public TeacherSearchModel(String lastName) {
        this.lastName =lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName =lastName;
    }
}
