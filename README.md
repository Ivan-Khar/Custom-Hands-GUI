# CustomHandGUI
This mod allows you to change hands position on screen

And you can change your main hand to be left hand!

![Screenshot](https://i.imgur.com/nyn4zW9.png)

# Keybindings:

* F - Swaps hands.
* G - Opens configuration screen.
* H - Resets hands position.
* J - Randomizes hands position.


# Configuration:

* *Pos - Position of the hand.
* *Rot - Rotation of the hand.
* Reset Position - Sets Positions and Rotations to 0
* Swap Hands - Swaps hands.
* Swap Chat - Changes chat position to the right side if your main hand is on the left side.
* Auto Refresh - Updates configuration file every 1 second.

# Mod showcase:
[![Video](https://img.youtube.com/vi/MHhldftIvxU/0.jpg)](https://www.youtube.com/watch?v=MHhldftIvxU)

# things for me:
Need to put this thing into CLI arguments of Minecraft Client configuration
```
--tweakClass org.spongepowered.asm.launch.MixinTweaker --mixin mixins.customgui.json
```