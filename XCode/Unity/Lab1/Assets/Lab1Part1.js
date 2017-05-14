var walkingKitty : Animator;  // variable for a walking cat animation
var scaredKitty : Animator;   // Variable for a scared cat animation

// ask the walking kitty to start walking
walkingKitty.Play( "Walk" );

// ask the scared kitty to stop playing its animation
// by assigning its speed to 0
scaredKitty.speed = 0;