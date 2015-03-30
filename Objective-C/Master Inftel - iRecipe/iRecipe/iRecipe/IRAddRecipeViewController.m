//
//  AddToDoItemViewController.m
//  ToDolist
//
//  Created by INFTEL 20 on 12/1/15.
//  Copyright (c) 2015 INFTEL 21. All rights reserved.
//

#import "IRAddRecipeViewController.h"
#import "IRDataLoader.h"

@interface IRAddRecipeViewController ()
@property (weak, nonatomic) IBOutlet UITextView *texArea;
@property (weak, nonatomic) IBOutlet UITextField *textField;
@property (weak, nonatomic) IBOutlet UIBarButtonItem *saveButton;
@property (weak, nonatomic) IBOutlet UITextField *namerecipe;
@property (weak, nonatomic) IBOutlet UITextField *elaboration_time;
@property (weak, nonatomic) IBOutlet UITextField *ingredient;
@property (weak, nonatomic) IBOutlet UITextField *imag;
@property (weak, nonatomic) IBOutlet UIButton *btnAddIngredients;
@property (weak, nonatomic) IBOutlet UITextField *texCantidad;
@property (weak, nonatomic) IBOutlet UITextField *tiempo;

@property (weak, nonatomic) IBOutlet UITextView *elaboration;

@end


@implementation IRAddRecipeViewController

@synthesize user;
@synthesize imagView,btnImag,chosenImage;

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    [self.btnAddIngredients addTarget:self action:@selector(buttonAddClicked) forControlEvents:UIControlEventTouchUpInside];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    @autoreleasepool {
        if (sender == self.saveButton ) {
            if((self.texArea.text.length <= 0) || (self.namerecipe.text.length <= 0) || (self.tiempo.text.length <= 0) || (self.elaboration.text.length <= 0)){
                return;
            }
            else{
                self.recipe = [[IRRecipe alloc] init];
                self.recipe.name = self.namerecipe.text;
                self.recipe.elaborationTime = self.tiempo.text;
                self.recipe.elaboration = self.elaboration.text;
                self.recipe.creationDate = [NSDate date];
                self.recipe.person = user;
                self.recipe.choosenFoto = [self crearImagen:chosenImage];
                [IRDataLoader insertRecipe:self.recipe withCallback:^{
                    NSArray *firstSplit = [self.texArea.text componentsSeparatedByString:@"\n"];
                    for(NSString * var in firstSplit)
                    {
                        NSLog(@"%@", var);
                        NSArray *SecondSplit = [[NSArray alloc] init];
                        SecondSplit = [var componentsSeparatedByString:@":"];
                        
                        //NSLog(@" grande %@", [SecondSplit objectAtIndex:1]);
                        
                        NSString *ingrediente = [SecondSplit objectAtIndex:0];
                        NSString *cantidad = [SecondSplit objectAtIndex:1];
                        
                        // paso a json
                        
                        IRIngredient *ingredient = [[IRIngredient alloc] init];
                        ingredient.name = ingrediente;
                        ingredient.quantity = cantidad;
                        ingredient.recipe = self.recipe;
                        
                        void (^callback)(NSURLResponse *, NSData *, NSError *) =
                        ^(NSURLResponse *response, NSData *data, NSError *error) {
                            if(data.length > 0 && error == nil){
                                
                            }
                        };
                        
                        [IRDataLoader insertIngredient:ingredient withCallback:callback];
                    }
                }];
            }
        }

    }
   
    }


-(void)buttonAddClicked{
    @autoreleasepool {
        
        if (self.ingredient.text.length > 0 )
        {
            NSString * texto = self.texArea.text;
            
            if(self.texArea.text.length <= 0)
            {
                if(self.texCantidad.text.length > 0)
                {
                    
                    self.texArea.text = [NSString stringWithFormat:@"%@:%@",[[self ingredient] text],[[self texCantidad] text]];
                }
                else
                {
                    self.texArea.text = [NSString stringWithFormat:@"%@:1",[[self ingredient] text]];
                }
            }
            else
            {
                if(self.texCantidad.text.length > 0)
                {
                    
                    self.texArea.text = [NSString stringWithFormat:@"%@\n%@:%@",texto,[[self ingredient] text],[[self texCantidad] text]];
                }
                else
                {
                    self.texArea.text = [NSString stringWithFormat:@"%@\n%@:1",texto,[[self ingredient]text]];
                }
            }
            
            self.ingredient.text = @"";
            self.texCantidad.text= @"";
        }
        
        else{
            return;
        }
    }
  
    
}



-(IBAction) getPhoto:(id) sender {
    @autoreleasepool {
        UIImagePickerController * picker = [[UIImagePickerController alloc] init];
        picker.delegate = self;
        picker.allowsEditing = YES;
        if((UIButton *) sender == btnImag) {
            picker.sourceType = UIImagePickerControllerSourceTypeSavedPhotosAlbum;
        }
        
        [self presentViewController:picker animated:YES completion:NULL];
    }
    
}

- (void)imagePickerController:(UIImagePickerController *)picker didFinishPickingMediaWithInfo:(NSDictionary *)info {
    chosenImage = info[UIImagePickerControllerEditedImage];
    self.imagView.image = chosenImage;
    [picker dismissViewControllerAnimated:YES completion:NULL];
}

- (void)imagePickerControllerDidCancel:(UIImagePickerController *)picker {
    
    [picker dismissViewControllerAnimated:YES completion:NULL];
}

-(NSString *) crearImagen:(UIImage *)im{
    @autoreleasepool {
        NSString *encodedstring;
        
        NSData *imagedata =UIImageJPEGRepresentation(im, 1.0f);
        
        encodedstring = [imagedata base64EncodedStringWithOptions:NSDataBase64Encoding64CharacterLineLength];
        
        return encodedstring;

    }
    
    }

@end