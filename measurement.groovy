import com.neuronrobotics.bowlerstudio.vitamins.*;



// Load an STL file from a git repo

// Loading a local file also works here

File servoFile = ScriptingEngine.fileFromGit(

	"https://github.com/NeuronRobotics/BowlerStudioVitamins.git",

	"BowlerStudioVitamins/stl/servo/smallservo.stl");

// Load the .CSG from the disk and cache it in memory

CSG servo  = Vitamins.get(servoFile);



//servo = servo.toZMax()// move servos maxZ to 0

servo = servo.toZMin()// move servos minZ to 0

//servo = servo.toXMax()// move servos maxX to 0

servo = servo.toXMin()// move servos zminX to 0

//servo = servo.toYMax()// move servos maxY to 0

servo = servo.toYMin()// move servos minY to 0



println "Maximum X dimention = " + servo.getMaxX()

println "Maximum Y dimention = " + servo.getMaxY()

println "Maximum Z dimention = " + servo.getMaxZ()



println "Minimum X dimention = " + servo.getMinX()

println "Minimum Y dimention = " + servo.getMinY()

println "Minimum Z dimention = " + servo.getMinZ()





println "Total X dimention = " + (-servo.getMinX()+servo.getMaxX())

println "Total Y dimention = " + (-servo.getMinY()+servo.getMaxY())

println "Total Z dimention = " + (-servo.getMinZ()+servo.getMaxZ())



println "Center in X dimention = " + ((servo.getMinX()/2)+(servo.getMaxX()/2))

println "Center in Y dimention = " + ((servo.getMinY()/2)+(servo.getMaxY()/2))

println "Center in Z dimention = " + ((servo.getMinZ()/2)+(servo.getMaxZ()/2))



/**

 * You can make functions to center objects usig this information

 */

CSG moveToXCenter(CSG incoming){

	return incoming.movex(((incoming.getMinX()/2)+(incoming.getMaxX()/2)))

}

CSG moveToYCenter(CSG incoming){

	return incoming.movey(((incoming.getMinY()/2)+(incoming.getMaxY()/2)))

}

CSG moveToZCenter(CSG incoming){

	return incoming.movez(((incoming.getMinZ()/2)+(incoming.getMaxZ()/2)))

}



return servo
