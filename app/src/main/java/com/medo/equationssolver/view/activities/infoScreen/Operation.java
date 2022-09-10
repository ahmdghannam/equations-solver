package com.medo.equationssolver.view.activities.infoScreen;
// the model
public class Operation {
   private String equations;
   private String result;
   private String activityName;

   public Operation(String equations, String results,String activityName) {
      this.equations = equations;
      this.result = results;
      this.activityName=activityName;
   }

   public String getEquations() {
      return equations;
   }

   public void setEquations(String equations) {
      this.equations = equations;
   }

   public String getResult() {
      return result;
   }

   public void setResult(String result) {
      this.result = result;
   }

   public String getActivityName() {
      return activityName;
   }

   public void setActivityName(String activityName) {
      this.activityName = activityName;
   }
}
