var msgText : TextMesh;  // Variable for the text above the cat

// variable to remeber how many times the cat has been clicked
// assign it to 0 to start off
var numClicks : int = 0;

/**
 * Function that will be invoked when cat is clicked.
 **/
function OnMouseDown()
{
 	//print to the Debug Console
 	Debug.Log( "Ow!" );
 	
 	// update the number of clicks
 	numClicks = numClicks + 1;
 	
 	// update the text above the cat
 	msgText.text = "Ow, that's " + numClicks + " pokes!";
}