import eu.mihosoft.vrl.v3d.parametrics.*;

ArrayList<CSG> makeStand() {
	LengthParameter thickness = new LengthParameter("Material Thickness", 2, [1, 10]);

	CSG bottom = new Cube(150, 50, thickness.getMM()).toCSG()
	CSG frontMiddle = new Cube(10, 50, thickness.getMM()).toCSG().rotx(60).movez(20).movey(-25)
	CSG frontLeft = new Cube(10, 50, thickness.getMM()).toCSG().rotx(60).movez(20).movey(-25).movex(60)
	CSG frontRight = new Cube(10, 50, thickness.getMM()).toCSG().rotx(60).movez(20).movey(-25).movex(-60)
	CSG front = new Cube(130, thickness.getMM(), 20).toCSG().movey(15).movez(10)

	bottom = bottom.difference(frontMiddle).difference(frontLeft).difference(frontRight).difference(front)

	return [bottom, frontMiddle, frontLeft, frontRight, front]
}

return makeStand()