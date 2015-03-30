//
//  AddToDoItemViewController.m
//  ToDoList
//
//  Created by INFTEL 18 on 12/1/15.
//  Copyright (c) 2015 INFTEL 18. All rights reserved.
//

#import "AddToDoItemViewController.h"

@interface AddToDoItemViewController ()
@property (weak, nonatomic) IBOutlet UITextField *textField;
@property (weak, nonatomic) IBOutlet UIBarButtonItem *saveButton;

@end

@implementation AddToDoItemViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    if (sender != self.saveButton) return;
    if (self.textField.text.length > 0) {
        self.toDoItem = [[ToDoItem alloc] init];
        self.toDoItem.itemName = self.textField.text;
        self.toDoItem.completed = NO;
    
        NSMutableDictionary *contentDictionary = [[NSMutableDictionary alloc]init];
        
        [contentDictionary setValue:[NSString stringWithFormat:@"%@",[[self textField] text]] forKey:@"cadena"];
        
        NSData *data = [NSJSONSerialization dataWithJSONObject:contentDictionary options:NSJSONWritingPrettyPrinted error:nil];
        NSString *post = [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
        
        
        // NSString *post = [NSString stringWithFormat:@"{\"cadena\" : \"%@\"}",self.textField.text];

        NSMutableURLRequest *urlRequest = [NSMutableURLRequest
                                           requestWithURL:[NSURL URLWithString:@"http://localhost:8080/ToDoList/webresources/modelo.list"]];
        
        urlRequest.HTTPMethod = @"POST";
        [urlRequest setValue:@"application/json; charset=utf-8" forHTTPHeaderField:@"Content-Type"];
        
        NSData *requestBodyData = [post dataUsingEncoding:NSUTF8StringEncoding];
        urlRequest.HTTPBody = requestBodyData;
        
        [NSURLConnection sendSynchronousRequest:urlRequest returningResponse:nil error:nil];
    }
}

@end
