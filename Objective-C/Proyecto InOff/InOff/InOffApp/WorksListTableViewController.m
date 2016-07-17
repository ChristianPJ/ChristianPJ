//
//  WorksListTableViewController.m
//  InOffApp
//
//  Created by Christian on 10/07/16.
//  Copyright (c) 2016 ChristianPJ. All rights reserved.
//

#import "WorksListTableViewController.h"
#import "IRDataLoader.h"
#import "IRWorks.h"

@interface WorksListTableViewController ()
@property NSMutableDictionary *works;
@property NSArray *worksSectionTitles;

@end

@implementation WorksListTableViewController


-  (void)loadInitialData {
    @autoreleasepool {
        [IRDataLoader loadWorks:self.works withCallback:^{
            self.worksSectionTitles = [[self.works allKeys] sortedArrayUsingSelector:@selector
                (localizedCaseInsensitiveCompare:)];
            [self.tableView reloadData];
        }];
    }
    
}


- (void)viewDidLoad {
    @autoreleasepool {
        [super viewDidLoad];
        self.works = [[NSMutableDictionary alloc] init];
        self.worksSectionTitles = [[NSArray alloc] init];
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
    return [self.worksSectionTitles count];
}


- (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section
{
    return [self.worksSectionTitles objectAtIndex:section];
}


- (NSArray *)sectionIndexTitlesForTableView:(UITableView *)tableView
{
    return self.worksSectionTitles;
}


- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    @autoreleasepool {
        // Return the number of rows in the section.
        NSString *sectionTitle = [self.worksSectionTitles objectAtIndex:section];
        NSArray *sectionWorks = [self.works objectForKey:sectionTitle];
        return [sectionWorks count];
    }
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    @autoreleasepool {
        UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"WorksListCell" forIndexPath:indexPath];
        // Configure the cell...
        NSString *sectionTitle = [self.worksSectionTitles objectAtIndex:indexPath.section];
        NSArray *sectionWorks = [self.works objectForKey:sectionTitle];
        IRWorks *work = [sectionWorks objectAtIndex:indexPath.row];
        cell.textLabel.text = work.nameWork;
        
        NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
        [dateFormatter setDateFormat:@"dd-MM-yyyy"];
        NSString *stringDate = [dateFormatter stringFromDate: work.dateWork];
        
        cell.detailTextLabel.text = stringDate;
        return cell;
    }
}


#pragma mark - Table view delegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    
}

@end
