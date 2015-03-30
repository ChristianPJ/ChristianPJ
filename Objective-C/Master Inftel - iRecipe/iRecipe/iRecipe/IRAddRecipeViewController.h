//
//  AddToDoItemViewController.h
//  iRecipe
//
//  Created by INFTEL 20 on 14/1/15.
//  Copyright (c) 2015 INFTEL 16. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "IRPerson.h"
#import "IRRecipe.h"

@interface IRAddRecipeViewController: UIViewController <UIImagePickerControllerDelegate, UINavigationControllerDelegate>{
    UIImageView * imagView;
    UIButton * btnImag;
    UIImage* chosenImage;
}

@property IRPerson *user;
@property IRRecipe *recipe;
@property UIImage* chosenImage;
@property (nonatomic, retain) IBOutlet UIImageView * imagView;
@property (nonatomic, retain) IBOutlet UIButton * btnImag;

-(IBAction) getPhoto:(id) sender;


@end
