//
//  ToDoListTableViewController.m
//  ToDolist
//
//  Created by INFTEL 20 on 12/1/15.
//  Copyright (c) 2015 INFTEL 21. All rights reserved.
//
#import "IRRecipesTableViewController.h"
#import "IRAddRecipeViewController.h"
#import "IRDataLoader.h"
#import "IRRecipe.h"


@interface IRRecipesTableViewController ()
@property NSMutableDictionary *recipes;
@property NSArray *recipeSectionTitles;

@end

@implementation IRRecipesTableViewController

@synthesize user;

-  (void)loadInitialData {
    @autoreleasepool {
        [IRDataLoader loadRecipes:self.recipes withCallback:^{
            self.recipeSectionTitles = [[self.recipes allKeys] sortedArrayUsingSelector:@selector(localizedCaseInsensitiveCompare:)];
            [self.tableView reloadData];
        }];
    }
    
}



- (void)viewDidLoad {
    @autoreleasepool {
        [super viewDidLoad];
        self.recipes = [[NSMutableDictionary alloc] init];
        self.recipeSectionTitles = [[NSArray alloc] init];
        [self loadInitialData];
    }
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    // Return the number of sections.
    return [self.recipeSectionTitles count];
}

- (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section
{
    return [self.recipeSectionTitles objectAtIndex:section];
}

- (NSArray *)sectionIndexTitlesForTableView:(UITableView *)tableView
{
    return self.recipeSectionTitles;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    @autoreleasepool {
        // Return the number of rows in the section.
        NSString *sectionTitle = [self.recipeSectionTitles objectAtIndex:section];
        NSArray *sectionAnimals = [self.recipes objectForKey:sectionTitle];
        return [sectionAnimals count];
    }
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    @autoreleasepool {
        UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"ListPrototypeCell" forIndexPath:indexPath];
    
        // Configure the cell...
        NSString *sectionTitle = [self.recipeSectionTitles objectAtIndex:indexPath.section];
        NSArray *sectionRecipes = [self.recipes objectForKey:sectionTitle];
        IRRecipe *recipe = [sectionRecipes objectAtIndex:indexPath.row];
        cell.textLabel.text = recipe.name;
        cell.detailTextLabel.text = recipe.elaborationTime;
        //cell.imageView.image = [UIImage imageNamed:[self getImageFilename:animal]];
    
        return cell;
    }
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


- (IBAction)unwindToList:(UIStoryboardSegue *)segue {
    IRAddRecipeViewController *source = [segue sourceViewController];
    IRRecipe *item = source.recipe;
    if (item != nil) {
        NSString *firstLetter = [[item.name substringToIndex:1] uppercaseString];
        NSMutableArray *recipesWithLetter = [self.recipes objectForKey:firstLetter];
        if(recipesWithLetter == nil){
            [self.recipes setObject:[[NSMutableArray alloc] init] forKey:firstLetter];
            recipesWithLetter = [self.recipes objectForKey:firstLetter];
        }
        [recipesWithLetter addObject:item];
        self.recipeSectionTitles = [[self.recipes allKeys] sortedArrayUsingSelector:@selector(localizedCaseInsensitiveCompare:)];
        [self.tableView reloadData];
    }
   
}



#pragma mark - Table view delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    //[tableView deselectRowAtIndexPath:indexPath animated:NO];
    //ToDoItem *tappedItem = [self.toDoItems objectAtIndex:indexPath.row];
    //tappedItem.completed = !tappedItem.completed;
    //[tableView reloadRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationNone];
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    @autoreleasepool {
        if ([segue.identifier isEqualToString:@"showRecipeDetail"]) {
            NSIndexPath *indexPath = [self.tableView indexPathForSelectedRow];
            IRRecipeDetailViewController *destViewController = segue.destinationViewController;
        
            NSString *sectionTitle = [self.recipeSectionTitles objectAtIndex:indexPath.section];
            NSArray *sectionRecipes = [self.recipes objectForKey:sectionTitle];
            IRRecipe *recipe = [sectionRecipes objectAtIndex:indexPath.row];

            destViewController.recipeId = recipe.idRecipe;
            destViewController.user = self.user;
        }
        if ([segue.identifier isEqualToString:@"addRecipe"]) {
            UINavigationController *navigation = (UINavigationController *)segue.destinationViewController;
            IRAddRecipeViewController *destViewController = (IRAddRecipeViewController *)navigation.topViewController;
            destViewController.user = user;
        }
    }
}

@end

