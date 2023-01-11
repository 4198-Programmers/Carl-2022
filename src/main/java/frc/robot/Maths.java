package frc.robot; 

public class Maths { 
        public static double rotationConversion(double distanceInInches) { 
            double circumference = (Math.PI * (Constants.JAKE_WHEELS)); 
            double rotation = distanceInInches / circumference; 
            return rotation; 
          }

          public static double circumference (double radius){
                double circumference = (Math.PI * (radius) *2d);
                return circumference; 
        }


          public static double distanceDegreeConversion(double degree, double radius) {
                double totalTurns = (degree / 360d); 
                double distance = (totalTurns * circumference(radius));
          return distance;
         }


         public static double circumferenceCircleRatio(double radius) {

                double circumferenceA = circumference(radius);
                double circumferenceB = circumference(radius + Constants.WIDTH_OF_JAKE); 
                double ratioDiffrenceCircle = (circumferenceB / circumferenceA); 
                return ratioDiffrenceCircle; 
        }

        public static double semiCircleCircumference (double radius){ 
                return circumference(radius)/2d; 
        }
  }


//radius is fro the inner wheel 




