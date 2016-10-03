ArrayList<CSG> makeShip() {
	CSG leftNacelle = new Cylinder(10, 10, 10, (int)30).toCSG()
	return [leftNacelle]
}

return makeShip()