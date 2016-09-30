import eu.mihosoft.vrl.v3d.parametrics.*;



CSG makeCube(){

	//Set up som parameters to use

	LengthParameter xkey 		= new LengthParameter("X dimention",30,[120.0,1.0])

	LengthParameter ykey 		= new LengthParameter("Y dimention",30,[130.0,2.0])

	LengthParameter zkey 		= new LengthParameter("Z dimention",30,[140.0,3.0])

	LengthParameter sphereSize 	= new LengthParameter("Sphere Size",30,[150.0,4.0])

	//you can also create parametrics that are not used in creating primitives

	LengthParameter offset	 	= new LengthParameter("Sphere Offset Distance",15,[20,-5])

	//build geometry with them

	CSG cube = new Cube(xkey,ykey,zkey).toCSG()	

	CSG sphere = new Sphere(sphereSize).toCSG()

	//apply moves based on the valeus in the parameters

	double distance = xkey.getMM()/2-offset.getMM()+sphereSize.getMM()

	cube=cube.union(sphere.movex(distance))

	return cube

		.setParameter(offset)// add any parameters that are not used to create a primitive

		.setRegenerate({ makeCube()})// add a regeneration function to the CSG being returrned to lonk a change event to a re-render

}

CSGDatabase.clear()//set up the database to force only the default values in			

return makeCube();
