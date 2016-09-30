//Move and rotate opperations

double leftHandX = 100

double leftHandY = 150

double leftHandZ = 50

CSG cube = new Cube(23, 26, 10).toCSG().movey(leftHandY + 7).movex(leftHandX).movez(leftHandZ+5)

CSG cylinder = new Cylinder(20, 20, 10,(int)30).toCSG().movex(leftHandX).movey(leftHandY).movez(leftHandZ)



CSG hand = cylinder.difference(new Cylinder(13, 13, 10, (int)30).toCSG()).difference(cube).scalex(0.5).scaley(0.5).scalez(0.5)

CSG rightHand = hand.movex(leftHandX).movey(leftHandY).movez(leftHandZ)

CSG leftHand = hand.movex(leftHandX-30).movey(leftHandY).movez(leftHandZ)



CSG elbow = new Cylinder(9, 9, 5, (int)30).toCSG()

CSG rightElbow = elbow.movex(150).movey(210).movez(-40).rotx(-35)

CSG rightWrist = new Cube(5, 5, 4).toCSG().movex(leftHandX+50).movey(leftHandY+68).movez(leftHandZ+27.5)

CSG rightForearm = new Cube(8, 8, 4).toCSG().movex(150).movey(210).movez(-40).rotx(-35)



CSG leftElbow = elbow.movex(120).movey(210).movez(-40).rotx(-35)

CSG leftWrist = new Cube(5, 5, 4).toCSG().movex(120).movey(leftHandY+68).movez(leftHandZ+27.5)

CSG leftForearm = new Cube(8, 8, 4).toCSG().movex(120).movey(210).movez(-40).rotx(-35)



CSG rightShoulder = new Cylinder(5, 5, 5, (int)30).toCSG().roty(90).movex(152.5).movey(185).movez(120).hull(rightForearm)

rightShoulder = rightShoulder.union(new Cylinder(3, 3, 5, (int)30).toCSG().roty(90).movex(155.5).movey(185).movez(120))

CSG leftShoulder = new Cylinder(5, 5, 5, (int)30).toCSG().roty(90).movex(122.5).movey(185).movez(120).hull(leftForearm)

leftShoulder = leftShoulder.union(new Cylinder(3, 3, 5, (int)30).toCSG().roty(90).movex(119.5).movey(185).movez(120))



CSG leftArm = leftHand.union(leftForearm.hull(leftWrist)).union(leftShoulder).union(leftElbow).movex(-15).movey(3).movez(2).setColor(javafx.scene.paint.Color.WHITE)

CSG rightArm = rightHand.union(rightForearm.hull(rightWrist)).union(rightShoulder).union(rightElbow).movex(15).movey(3).movez(2).setColor(javafx.scene.paint.Color.WHITE)



CSG head = new RoundedCube(4, 40, 42).cornerRadius(12).toCSG().movez(20).hull(new Cylinder(23, 23, 30, (int)50).toCSG().movez(5))

CSG headHat = new Cylinder(10, 10, 7, (int)30).toCSG().difference(new Cylinder(7, 7, 7, (int)30).toCSG()).movex(135).movey(188).movez(167)

head = head.movex(169).movey(235).movez(170).scalex(0.8).scaley(0.8).scalez(0.8).union(headHat).setColor(javafx.scene.paint.Color.WHITE)



CSG leftEye = new Sphere(40).toCSG().scalex(0.1).scaley(0.05).scalez(0.1).movex(143).movey(203.5).movez(155).setColor(javafx.scene.paint.Color.BLACK)

CSG rightEye = new Sphere(40).toCSG().scalex(0.1).scaley(0.05).scalez(0.1).movex(128).movey(203.5).movez(155).setColor(javafx.scene.paint.Color.BLACK)

CSG nose = new Cylinder(3, 1, 4, (int)30).toCSG().movex(135).movey(205).movez(150).setColor(javafx.scene.paint.Color.BLACK)

CSG mouth = Extrude.points(new Vector3d(0, 0, 5),// This is the  extrusion depth

                new Vector3d(0,-10,10),// All values after this are the points in the polygon

                new Vector3d(15,-10,6),// Bottom right corner

                new Vector3d(25,-25),

                new Vector3d(30, -20),

                new Vector3d(35, -25),

                new Vector3d(40, -20),

                new Vector3d(45, -25),

                new Vector3d(50, -20),

                new Vector3d(55, -25),

                new Vector3d(65, -10,6),

                new Vector3d(80, -10,10),

                new Vector3d(70, -15,6.5),

                new Vector3d(55, -35),

                new Vector3d(50, -30),

                new Vector3d(45, -35),

                new Vector3d(40, -30),

                new Vector3d(35, -35),

                new Vector3d(30, -30),

                new Vector3d(25, -35),

                new Vector3d(10, -15,6.5)).rotx(-90).movex(326).movey(558).movez(417).scalex(0.37).scaley(0.37).scalez(0.37).setColor(javafx.scene.paint.Color.BLACK)

CSG neck = new Cylinder(10, 10, 7, (int)30).toCSG().difference(new Cylinder(7, 7, 7, (int)30).toCSG()).movex(135).movey(188).movez(131).setColor(javafx.scene.paint.Color.WHITE)

CSG spine = new Cylinder(7, 7, 60, (int)30).toCSG().movex(135).movey(188).movez(72).setColor(javafx.scene.paint.Color.WHITE)

CSG[] spinalCords = [

			new Cylinder(9, 9, 4, (int)30).toCSG().movex(135).movey(188).movez(72),

			new Cylinder(9, 9, 4, (int)30).toCSG().movex(135).movey(188).movez(82),

			new Cylinder(9, 9, 4, (int)30).toCSG().movex(135).movey(188).movez(92),

			new Cylinder(9, 9, 4, (int)30).toCSG().movex(135).movey(188).movez(102),

			new Cylinder(9, 9, 4, (int)30).toCSG().movex(135).movey(188).movez(112),

			new Cylinder(9, 9, 4, (int)30).toCSG().movex(135).movey(188).movez(122)]



for (int i = 0; i < spinalCords.size(); i++) {

	spinalCords[i] = spinalCords[i].setColor(javafx.scene.paint.Color.WHITE)

}



CSG waist = new Cube(50, 14, 5).toCSG().movex(135).movey(188).movez(69.5)

waist = waist.union(new Cube(5, 14, 16).toCSG().movex(143).movey(188).movez(60))

waist = waist.union(new Cube(5, 14, 16).toCSG().movex(127).movey(188).movez(60))

waist = waist.union(new Cylinder(3, 3, 15, (int)30).toCSG().roty(90).movex(143).movey(188).movez(58)).setColor(javafx.scene.paint.Color.WHITE)



CSG rightLeg = new Cylinder(6, 6, 10, (int)30).toCSG().roty(90).movex(155).movey(188).movez(58)

rightLeg = rightLeg.union(new Cylinder(4, 4, 3, (int)30).toCSG().roty(90).movex(157).movey(188).movez(58))

rightLeg = rightLeg.union(new Cylinder(5, 5, 50, (int)30).toCSG().movex(150).movey(188).movez(10))

rightLeg = rightLeg.union(new Cylinder(8, 8, 5, (int)30).toCSG().movex(150).movey(188).movez(27))

rightLeg = rightLeg.union(new Cylinder(9, 9, 10, (int)30).toCSG().movex(150).movey(188)).setColor(javafx.scene.paint.Color.WHITE)

CSG leftLeg = new Cylinder(6, 6, 10, (int)30).toCSG().roty(90).movex(125).movey(188).movez(58)

leftLeg = leftLeg.union(new Cylinder(4, 4, 3, (int)30).toCSG().roty(90).movex(116).movey(188).movez(58))

leftLeg = leftLeg.union(new Cylinder(5, 5, 50, (int)30).toCSG().movex(120).movey(188).movez(10))

leftLeg = leftLeg.union(new Cylinder(8, 8, 5, (int)30).toCSG().movex(120).movey(188).movez(27))

leftLeg = leftLeg.union(new Cylinder(9, 9, 10, (int)30).toCSG().movex(120).movey(188)).setColor(javafx.scene.paint.Color.WHITE)



CSG chest = new Cube(60, 5, 4).toCSG().movex(135).movey(188).movez(124)

chest = chest.union(new Cube(35, 5, 4).toCSG().roty(21).movex(147).movey(188).movez(116))

chest = chest.union(new Cube(35, 5, 4).toCSG().roty(-21).movex(123).movey(188).movez(116))

chest = chest.union(new Cube(40, 5, 4).toCSG().roty(40).movex(149).movey(188).movez(110))

chest = chest.union(new Cube(40, 5, 4).toCSG().roty(-40).movex(121).movey(188).movez(110))

chest = chest.union(new Cube(45, 5, 4).toCSG().roty(55).movex(150).movey(188).movez(104))

chest = chest.union(new Cube(45, 5, 4).toCSG().roty(-55).movex(120).movey(188).movez(104))

chest = chest.union(new Cube(50, 5, 4).toCSG().roty(60).movex(151).movey(188).movez(98))

chest = chest.union(new Cube(50, 5, 4).toCSG().roty(-60).movex(119).movey(188).movez(98)).setColor(javafx.scene.paint.Color.WHITE)



spinalCords[0] = spinalCords[0].scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

spinalCords[1] = spinalCords[1].scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

spinalCords[2] = spinalCords[2].scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

spinalCords[3] = spinalCords[3].scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

spinalCords[4] = spinalCords[4].scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

spinalCords[5] = spinalCords[5].scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

spine = spine.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

leftArm = leftArm.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

rightArm = rightArm.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

head = head.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

leftEye = leftEye.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.BLACK)

rightEye = rightEye.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.BLACK)

nose = nose.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.BLACK)

mouth = mouth.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.BLACK)

neck = neck.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

waist = waist.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

leftLeg = leftLeg.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

rightLeg = rightLeg.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)

chest = chest.scalex(0.5).scaley(0.5).scalez(0.5).setColor(javafx.scene.paint.Color.WHITE)



ghost = new Sphere(12).toCSG().movex(68).movey(93).movez(80)

ghost = ghost.hull(new Cube(25, 15, 30).toCSG().movex(68).movey(93).movez(15))

ghost = ghost.difference(new Cube(25, 12, 64).toCSG().movex(68).movey(93).movez(32))

ghost = ghost.difference(new Sphere(11).toCSG().movex(68).movey(93).movez(80))

ghost = ghost.difference((new Cube(20, 12, 80).toCSG().movex(68).movey(93).movez(40)))

ghost = ghost.union(new Cylinder(7, 7, 5, (int)30).toCSG().movex(68).movey(93).movez(84))

ghost = ghost.movez(100)

ghost = ghost.setColor(javafx.scene.paint.Color.GREEN)



CSG body = spine.union(spinalCords[0]).union(spinalCords[1]).union(spinalCords[2]).union(spinalCords[3]).union(spinalCords[4]).union(spinalCords[5]).union(chest).union(leftArm).union(rightArm).union(waist).union(leftLeg).union(rightLeg)

body = body.setColor(javafx.scene.paint.Color.WHITE)

head = head.union(neck).difference(leftEye).difference(rightEye).difference(nose).difference(mouth).setColor(javafx.scene.paint.Color.WHITE)

return [body,

		head,

		ghost]
