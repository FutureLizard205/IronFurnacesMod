# Iron Furnaces Mod for BTA 7.1

A simple mod that adds higher tiered furnaces.
Has BTWaila support.

Details: 

| Furnace Tier | Fuel Yield | Speed | Block IDs |
| ------------ | ---------- | ----- | --------- |
| Iron         | 125%       | 125%  | 664, 665  |
| Gold         | 80%        | 160%  | 666, 667  |
| Diamond      | 150%       | 200%  | 668, 669  |
| Steel        | 250%       | 100%  | 674, 675  |

Note: Fuel Yield here is in terms of items smelt per fuel used, not in terms of time burning per fuel used

### Config File
All of the values in the table above can be changed in the TOML config file.

The ID for the furnace's active block is always 1 + the respective idle block's ID.

### Known Bugs
- None so far :)

## Dependencies for latest version:
- [HalpLibe](https://github.com/Turnip-Labs/bta-halplibe) >= 3.1.0

## Recommended:
- [BTWaila](https://github.com/ToufouMaster/BTWaila) >= 1.0.2
