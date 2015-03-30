//
//  IngredientsTableViewController.m
//  iRecipe
//
//  Created by INFTEL 18 on 16/1/15.
//  Copyright (c) 2015 INFTEL 16. All rights reserved.
//

#import "IRIngredientsTableViewController.h"

@interface IRIngredientsTableViewController ()

@property NSMutableArray *ingredients;

@end

@implementation IRIngredientsTableViewController

@synthesize recipeIdIngred;

-  (void)loadInitialData {
    [IRDataLoader loadIngredients:self.ingredients withRecipe:recipeIdIngred withCallback:^{
        [self.tableView reloadData];
        [IRDataLoader loadIngredientChecked:self.ingredients withUser:self.user withRecipe:recipeIdIngred withCallback:^{
            [self.tableView reloadData];
        }];
    }];
}


- (void)viewDidLoad {
    [super viewDidLoad];
    self.ingredients = [[NSMutableArray alloc] init];
    [self loadInitialData];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    // Return the number of sections.
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {

    // Return the number of rows in the section.
    return [self.ingredients count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"ListIngredientsCell" forIndexPath:indexPath];
    
    IRIngredient *ingred = [self.ingredients objectAtIndex:indexPath.row];
    //NSString *cadena = [NSString stringWithFormat:@"%@ %@",ingred.quantity,ingred.name];
    cell.textLabel.text = ingred.name;
    cell.detailTextLabel.text = ingred.quantity;
    if(ingred.completed) {
        cell.accessoryType = UITableViewCellAccessoryCheckmark;
    } else {
        cell.accessoryType = UITableViewCellAccessoryNone;
    }
    
    return cell;
}


/*
// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the specified item to be editable.
    return YES;
}
*/

/*
// Override to support editing the table view.
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        // Delete the row from the data source
        [tableView deleteRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationFade];
    } else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
    }   
}
*/

/*
// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath {
}
*/

/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    for (IRIngredient *ingredient in self.ingredients){
        [IRDataLoader insertIngredientChecked:ingredient withUser:self.user];
    }
}
*/

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    [tableView deselectRowAtIndexPath:indexPath animated:NO];
    IRIngredient *tappedItem = [self.ingredients objectAtIndex:indexPath.row];
    tappedItem.completed = !tappedItem.completed;
    [tableView reloadRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationNone];
    NSLog(@"%@", tappedItem.idIngredient);
    NSLog(@"%@", tappedItem.idIngredient);
    [IRDataLoader insertIngredientChecked:tappedItem withUser:self.user];
}

@end
