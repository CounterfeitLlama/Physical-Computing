import eu.mihosoft.vrl.v3d.parametrics.*;



ArrayList<CSG> makePart() {

	LengthParameter thickness = new LengthParameter("Material Thickness",3.15,[10,1])



	double xdimension = 40

	CSG cube = new Cylinder(xdimension,

					xdimension,

					thickness.getMM(),

					(int)30

					).toCSG()



	CSG cube2 = new Cylinder(xdimension,

					xdimension,

					thickness.getMM(),

					(int)30

					).toCSG()



	/*

	 * Adds thickness parameter to each object

	 */

	 

	cube = cube.difference(cube2.movex(-xdimension/2))

	cube2 = cube2.difference(cube.movey(30))

	cube2 = cube2.movex(-xdimension - 30)

	

	def listOfParts = [cube, cube2]

	for (int i = 0; i < listOfParts.size(); i++) {

		int local = i;

		listOfParts.get(local)

					.setParameter(thickness)

					.setRegenerate({

						return makePart().get(local)

					})

	}

	

	return listOfParts

}



return makePart()

