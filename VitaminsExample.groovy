import com.neuronrobotics.bowlerstudio.vitamins.Vitamins;

import eu.mihosoft.vrl.v3d.parametrics.*;

// to add your own viatamins, fork https://github.com/madhephaestus/Hardware-Dimensions and make your modifications there. 



class allViataminMaker implements IParameterChanged{

	ArrayList <CSG> examples = null

	ArrayList <CSG> getParts(){

		if(examples!=null)

			return examples

		examples = new ArrayList<>()

		int numVits = 0;

		for(String type: Vitamins.listVitaminTypes()){

			String script = Vitamins.getMeta(type).get("scriptGit")

			println type+" from "+script

			for(String size:Vitamins.listVitaminSizes(type) ){

		

				HashMap<String, Object>  vitaminData = Vitamins.getConfiguration( type,size)

				println "\tSize = "+size+" "+vitaminData

			}

			

			if(script!=null){

				// Grab the first vitamin from the list and load that

				ArrayList<String> options = Vitamins.listVitaminSizes(type);

				StringParameter typParam = new StringParameter(	type+" Default",

														options.get(0),

														options)

				CSG vitaminFromScript = Vitamins.get( type,typParam.getStrValue())

									.movey(40*numVits++)

				CSGDatabase.addParameterListener(typParam.getName(),this);

				vitaminFromScript.setRegenerate({getParts()})					

				examples.add(vitaminFromScript)

			}else

				println "ERROR no script for "+type

		}

		for(int i=0;i<examples.size();i++){

			int index = i

			examples.get(i)

				.setRegenerate({getParts().get(index)})

		}

		return examples

	}

	/**

	 * This is a listener for a parameter changing

	 * @param name

	 * @param p

	 */

	 

	public void parameterChanged(String name, Parameter p){

		println name+" changed "+p.getStrValue()

		examples=null

	}

	

}



new allViataminMaker().getParts()
