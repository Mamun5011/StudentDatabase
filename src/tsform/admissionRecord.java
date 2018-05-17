
package tsform;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

 public class admissionRecord {
        private  SimpleIntegerProperty studentroll;    
        private  SimpleStringProperty studentName;
        private SimpleDoubleProperty studentmarks;
           
           
           
           
           
         
        admissionRecord(int i, String v0, Double v1)
        {
            this.studentroll = new SimpleIntegerProperty(i);
            this.studentName = new SimpleStringProperty(v0);
            this.studentmarks = new SimpleDoubleProperty(v1);
        }
        
        
     

    public Integer getStudentroll() {
        return this.studentroll.get();
    }

    
 
        public void  setStudentroll(int a) {
         this.studentroll.set(a);// = new SimpleIntegerProperty(a);
    }
        
            public IntegerProperty studentrollProperty() { 
         return studentroll; 
     }
    
    
    public String getStudentName() {
        return this.studentName.get();
       
    }
    
            public void  setStudentName(String a) {
         this.studentName.set(a);// = new SimpleStringProperty(a);
    }

    public Double getStudentmarks() {
        return studentmarks.get();
    }
    
        public void setStudentmarks(Double a) {
                   this.studentmarks.set(a);// = new SimpleDoubleProperty(a);

    }

 
         
      
         
    };
