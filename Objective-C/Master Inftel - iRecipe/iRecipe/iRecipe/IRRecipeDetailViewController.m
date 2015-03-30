//
//  RecipeDetailViewController.m
//  iRecipe
//
//  Created by INFTEL 18 on 14/1/15.
//  Copyright (c) 2015 INFTEL 16. All rights reserved.
//

#import "IRRecipeDetailViewController.h"

@interface IRRecipeDetailViewController ()

@property IRRecipe *fullRecipe;

@end

@implementation IRRecipeDetailViewController

@synthesize user;
@synthesize recipeId;

@synthesize recipeLabel;

@synthesize recipeLabelTime;

@synthesize recipeTextView;

@synthesize recipeLabelDate;

@synthesize recipeLabelUser;

@synthesize recipeImageView;

-  (void)loadInitialData {
    @autoreleasepool {
        [IRDataLoader loadRecipeWithId:recipeId intoRecipe:self.fullRecipe withCallback:^{
            recipeLabel.text = self.fullRecipe.name;
            recipeLabelTime.text = self.fullRecipe.elaborationTime;
            recipeTextView.text = self.fullRecipe.elaboration;
            
            NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
            [dateFormatter setDateFormat:@"dd-MM-yyyy"];
            NSString *stringDate = [dateFormatter stringFromDate:self.fullRecipe.creationDate];
            
            recipeLabelDate.text = stringDate;
            recipeLabelUser.text = self.fullRecipe.person.name;
            
            if(self.fullRecipe.choosenFoto == nil)
            {
                UIImage *img = [UIImage imageNamed:@"Comer.jpg"];
                recipeImageView.image =img;
            }
            else
            {
                NSData* dataImage = [[NSData alloc] initWithBase64EncodedString:self.fullRecipe.choosenFoto options:0];
                UIImage *img = [UIImage imageWithData:dataImage];
                recipeImageView.image =img;
            }
            
        }];

    }
    }


- (void)viewDidLoad {
    [super viewDidLoad];
    self.fullRecipe = [[IRRecipe alloc] init];
    [self loadInitialData];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    UINavigationController *navigation = (UINavigationController *)segue.destinationViewController;
    IRIngredientsTableViewController *destViewController = (IRIngredientsTableViewController *)navigation.topViewController;
    
    destViewController.recipeIdIngred = self.fullRecipe;
    destViewController.user = self.user;
}


@end
