Perfect-Armour
==============

A mod to create armour tiers that fit with your pack/server.


  {
    "id": "0",
    "textureName": "leather",
    "displayName": "Leather",
    "hasOverlay": true,
    "helmet": {
      "displayName": "Helmet",
      "durability": 56,
      "maxAbsorption": 500000,
      "absorptionRatio": 0.04,
      "recipe": {
        "top": "xxx",
        "middle": "x x",
        "bottom": "   ",
        "x": "334"
      }
    }
    
id          = Unique ID number for each set.
textureName = Name of the textures used from the mod. [List here](https://github.com/CCM-Modding/Perfect-Armour/tree/master/resources/assets/perfectarmor/textures/items)
displayName = Name used for the set. Each part of the armour will have this followed by the parts name.
hasOverlay  = If the texture uses a overlay on the armour. DO NOT USE IF THERE IS NO OVERLAY!
helmet      = The part of the set you are configuring.
displayName   = Name that shows up after the set displayName.
durability    = How much durability the part has.
maxAbsorption   = Maximum amout of dmamge untill the armour dose not work. Think of it as a limiter.
absorptionRatio = Percentage of damabe absorbed per durability. Must be between 0.01-1 Each 0.04 = Half a armor ingmae.
recipe          = What it takes to craft the item in a crafting table. Think of it like the crafting grid.
"x": "334" = Material that is used in the crafting. If you want to use more than one item copy the line and change the x to another letter and change 334 to th items ID you wish to use. If the item has metadata use & instead of : like this 5&1
