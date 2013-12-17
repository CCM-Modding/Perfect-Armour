Perfect-Armor
==============

A mod to create armor tiers that fit with your pack/server.
```
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
}
```
- **id** = Unique ID number for each set. Take the last one and add one.        

- **textureName** = Name of the textures used from the mod. [List here](https://github.com/CCM-Modding/Perfect-Armour/tree/master/resources/assets/perfectarmor/textures/items)  

- **displayName** = Name used for the set. Each part of the armour will have this followed by the part's name.       

- **hasOverlay** = If the texture uses a overlay on the armour. **DO NOT USE IF THERE IS NO OVERLAY TEXTURE!** 

- **helmet** = The part of the set you are configuring. The parts are: helmet, chest, pants, boots.          

- **displayName** = Name that shows up after the set's displayName.     

- **durability** = How much durability the part has.         

- **maxAbsorption** = Maximum amout of dmamge untill the armour dose not work. Think of it as a limiter.

- **absorptionRatio** = Percentage of damabe absorbed per durability. Must be between 0.01-1 Each 0.04 =  Half a armor inside of the game. 

- **recipe** = What it takes to craft the item in a crafting table. Think of it like the crafting grid.             

- **"x": "334"** = Material that is used in the crafting. If you want to use more than one item, copy the line and change the x to another letter then change 334 to the item ID you wish to use. If the item has metadata then it would be itemID&metadata. For example: 32&5 for item id 32 with metadata 5.          
