//
//  UILoginViewController.m
//  iRecipe
//
//  Created by INFTEL 18 on 15/1/15.
//  Copyright (c) 2015 INFTEL 16. All rights reserved.
//

#import "IRLoginViewController.h"
#import "IRPerson.h"
#import "IRRecipesTableViewController.h"
#import "IRDataLoader.h"

@interface IRLoginViewController ()

@property (nonatomic, strong) IBOutlet UITextField *userLogin;
@property (nonatomic,strong) IBOutlet UIButton *buttonLogin;

@end

@implementation IRLoginViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    [self.buttonLogin addTarget:self action:@selector(buttonLoginClicked)
          forControlEvents:UIControlEventTouchUpInside];
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    UINavigationController *navigation = (UINavigationController *)segue.destinationViewController;
    IRRecipesTableViewController *destViewController = (IRRecipesTableViewController *)navigation.topViewController;
    
    void (^callback)(NSURLResponse *, NSData *, NSError *) =
    ^(NSURLResponse *response, NSData *data, NSError *error) {
        if(data.length > 0 && error == nil){
            dispatch_queue_t mainQueue = dispatch_get_main_queue();
            
            NSError *errorJSON;
            NSDictionary *object = [NSJSONSerialization JSONObjectWithData:data options:NSJSONReadingMutableContainers error:&errorJSON];
            
            IRPerson *newPerson = [[IRPerson alloc] init];
            newPerson.idPerson = [object valueForKey:@"id"];
            newPerson.name = [object valueForKey:@"name"];
            
            
            dispatch_async(mainQueue, ^{
                destViewController.user = newPerson;
            });
        }
    };
    
    [IRDataLoader loadPersonWithName:self.userLogin.text withCallback:callback];
}


-(void)buttonLoginClicked{
    
    if([self.userLogin.text length] < 1){
        return;
    }
    [self performSegueWithIdentifier:@"showRecipes" sender:nil];
}

@end
