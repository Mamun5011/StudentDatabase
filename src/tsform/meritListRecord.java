/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsform;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mamun
 */
public class meritListRecord {
    
            private  SimpleIntegerProperty studentroll;    
        private  SimpleStringProperty studentName;
         private SimpleDoubleProperty studentCt1;
         private SimpleDoubleProperty studentCt2;
         private SimpleDoubleProperty studentCt3;
        private SimpleDoubleProperty studentTerm1;
          private SimpleDoubleProperty studentTerm2;
           private SimpleDoubleProperty studentTerm3;
           private SimpleDoubleProperty studentLab;
           private SimpleDoubleProperty studentMarks;
           
                   meritListRecord(int i, String v0, Double v1, Double v2, Double v3, 
                Double v4,Double v5,Double  v6,Double v7,Double v8) {
            this.studentroll = new SimpleIntegerProperty(i);
            this.studentName = new SimpleStringProperty(v0);
            this.studentCt1 = new SimpleDoubleProperty(v1);
            this.studentCt2 = new SimpleDoubleProperty(v2);
            this.studentCt3 = new SimpleDoubleProperty(v3);
            this.studentTerm1 = new SimpleDoubleProperty(v4);
            this.studentTerm2 = new SimpleDoubleProperty(v5);
            this.studentTerm3 = new SimpleDoubleProperty(v6);
            this.studentLab= new SimpleDoubleProperty(v7);
            this.studentMarks=new SimpleDoubleProperty(v8);
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

    public Double getStudentCt1() {
        return studentCt1.get();
    }
    
        public void setStudentCt1(Double a) {
                   this.studentCt1.set(a);// = new SimpleDoubleProperty(a);

    }

    public Double getStudentCt2() {
        return studentCt2.get();
    }
    
    
        public void  setStudentCt2(Double a) {
         this.studentCt2.set(a);// = new SimpleDoubleProperty(a);
    }

    public Double getStudentCt3() {
        return studentCt3.get();
    }
    
            public void  setStudentCt3(Double a) {
         this.studentCt3.set(a);// = new SimpleDoubleProperty(a);
    }
            
            

    public Double getStudentTerm1() {
        return studentTerm1.get();
    }
    
                public void  setStudentTerm1(Double a) {
         this.studentTerm1.set(a);// = new SimpleDoubleProperty(a);
    }

    public Double getStudentTerm2() {
        return studentTerm2.get();
    }
    
                    public void  setStudentTerm2(Double a) {
         this.studentTerm2.set(a);// = new SimpleDoubleProperty(a);
    }
                    
                    

    public Double getStudentTerm3() {
        return studentTerm3.get();
    }
    
                    public void  setStudentTerm3(Double a) {
         this.studentTerm3.set(a);// = new SimpleDoubleProperty(a);
    }
                    
    
    public Double getStudentLab() {
        return studentLab.get();
    }    
    
                        public void  setStudentLab(Double a) {
         this.studentLab.set(a);// = new SimpleDoubleProperty(a);
    }
                        
       public Double getStudentMarks() {
        return studentMarks.get();
    }    
    
                        public void  setStudentMarks(Double a) {
         this.studentMarks.set(a);// = new SimpleDoubleProperty(a);
    }                     
                       
    
    
}


