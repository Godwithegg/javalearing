#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int saveflag=0;
void Menu()
{
    printf("\n\n\n\t\t\t\tStudent achievement management system\n\n");
    printf("\t\t\t******************  Main menu  *********************\n");
    printf("\t\t\t*     1 Input record      2 Delete record          *\n");
    printf("\t\t\t*     3 Query record      4 Modify record          *\n");
    printf("\t\t\t*     5 insert record     6 Statistical records    *\n");
    printf("\t\t\t*     7 sort record       8 Save record            *\n");
    printf("\t\t\t*     9 Display record    0 Exit system            *\n");
    printf("\t\t\t****************************************************\n");
}
void wire()
{
    printf("\t-------------------------------------------------------------\n");
}
void sign()
{
    printf("\t-----------------Student information-------------------------\n");
    printf("\t| Num. | name | eng. | math | Clag. | total. | aver. | rank |\n");
}

struct student
{
    char name[20];
    char number[20];
    float total;
    float ave;
    int english;
    int math;
    int c;
    int rank=0;
};
typedef struct node
{
    struct student data;
    struct node *next;
}Node,*link;
void printfd(Node *p)
{
    printf("\t| %4s | %4s | %4d | %4d | %5d | %.2f | %.2f | %4d |\n",p->data.number,p->data.name,
           p->data.english,p->data.math,p->data.c,p->data.total,p->data.ave,p->data.rank);
}
void Add(link l)
{
    Node *p,*q,*head;
    char number[10];
    char student[20];
    head=l;
    q=l->next;
    while(head->next!=NULL)

        head=head->next;
        while(1)
        {
            printf("Enter student number<press'0'back menu>:");
            scanf("%s",number);
            if(strcmp(number,"0")==0)
                {
                    Menu();
                    break;
                }
            while(q)
            {
                if(strcmp(q->data.number,number)==0)
                {
                    printf("No.%s:Student information:");
                    sign();
                    printfd(q);
                    printf("\n");
                    return ;

                }
                q=q->next;
            }
        p=new Node;
        strcpy(p->data.number,number);
        printf("name:");
        scanf("%s",p->data.name);
        getchar();
        printf("Clanguage achievement[0--100]:");
        scanf("%d",&p->data.c);
        getchar();
        printf("Mathematics achievement[0--100]:");
        scanf("%d",&p->data.math);
        getchar();
        printf("English achievement[0--100]:");
        scanf("%d",&p->data.english);
        getchar();
        p->data.total=p->data.english+p->data.math+p->data.c;
        p->data.ave=p->data.total/3;
        p->next=NULL;
        head->next=p;
        head=p;
        saveflag=1;
        }
}

Node *Locate(link l,char findmess[],char nameornum[])
{
    Node *p;
     if(strcmp(nameornum,"number")==0)
    {
        p=l->next;
        while(p!=NULL)
        {
            if(strcmp(p->data.number,findmess)==0)
                return p;
            p=p->next;
        }
    }
        else if(strcmp(nameornum,"name")==0)
        {
            p=l->next;
            while(p!=NULL)
            {
                if(strcmp(p->data.name,findmess)==0)
                    return p;
                p=p->next;
            }
        }
        return 0;

}
void Save(link l)
{
    FILE* fp;
    Node *p;
    int flag,cout=0;
    flag=1;
    fp=fopen("D:\\student","wb");
    if(fp==NULL)
    {
        printf("Open exception\n");
        exit(1);
    }
    p=l->next;
    while(p)
    {
        if(fwrite(p,sizeof(Node),1,fp)==1)
        {
            p=p->next;
            cout++;
        }
        else
        {
            flag=0;
            break;
        }
    }
    if(flag)
    {
        Menu();
        printf("8");
        printf("\n====>File save completed,The total record saved is:%d\n",cout);
        saveflag=0;
    }
    fclose(fp);
}
void Qur(link l)
{
    int choose;
    char name[20];
    node *p;
    if(l->next==NULL)
    {
        printf("No student data\n");
        return ;
    }
    printf("====>1Query by student number ====>2Query by name\n");
    printf("  Input selection[1,2]:");
    scanf("%d",&choose);
    if(choose==1)
    {
        printf("Enter an existing student number:");
        scanf("%s",name);
        p=Locate(l,name,"number");
        if(p)
        {
            sign();
            wire();
            printfd(p);
            wire();
            system("pause");
            Menu();
        }
        else {
                printf("====>The student was not found\n");
                system("pause");
                Menu();
             }
    }
    else if(choose==2)
    {
        printf("The name you are looking for is:");
        scanf("%s",name);
        p=Locate(l,name,"name");
        if(p)
        {
            sign();
            wire();
            printfd(p);
            wire();
            system("pause");
                Menu();
        }
        else {
                printf("Can't find\n");
                system("pause");
                Menu();
             }
    }
    else {
            printf("Can't find\n");
            system("pause");
            Menu();
         }
}
void Del(link l)
{
    int choose,number;
    char name[20];
    Node *p,*q,*r;
    char ch[20];
    if(l->next==NULL)
    {
        printf("Cannot delete\n");
        system("pause");
        Menu();
        return ;
    }
    p=new Node;
    //Disp();
    printf("\n====>1 Delete by student number ====>2Delete by name\n");
    printf("Input selection[1,2]:");
    scanf("%d",&choose);
    if(choose==1)
    {
        printf("Enter an existing student number:");
        scanf("%s",name);
        p=Locate(l,name,"number");
        if(p)
        {
            q=l;
            while(q->next!=p)
                q=q->next;

            q->next=p->next;
            free(p);

            printf("\n====>Delete successfully!\n");
            saveflag=1;
        }
        else printf("There is no student\n");
    }
    else if(choose==2)
    {
        printf("Enter the existing student name:");
        scanf("%s",name);
        p=Locate(l,name,"name");
        if(p)
        {
            q=l;
            while(q->next!=p)
            q=q->next;
            q->next=p->next;
            free(p);
            printf("====>Delete successfully!\n");
            saveflag=1;
        }
        else printf("There is no student\n");
    }
}
void Disp(link l)
{
    int count=0;
    Node *p;
    p=l->next;
    if(p==NULL)
    {
        printf("No student information can be displayed\n");
        system("pause");
        Menu();
        return ;
    }
    sign();
    while(p)
    {
        printfd(p);
        p=p->next;
    }
    wire();
    printf("\n");
}
void Modify(link l)
{
    Node *p;
    char findmess[20];
    if(l->next==NULL)
    {
        printf("No student information can be modified\n");
        return ;
    }
    printf("Enter an existing student number:");
    scanf("%s",findmess);
    printf("\n");
    p=Locate(l,findmess,"number");
    if(p)
    {
        sign();
        printfd(p);
        wire();
        printf("No.:");
        scanf("%s",p->data.number);
        printf("name:%s,Enter new name:",p->data.name);
        scanf("%s",p->data.name);
        getchar();
        printf("Clanguage achievement:%d,cLanguage achievement range[0--100]:",p->data.c);
        scanf("%d",&p->data.c);
        getchar();
        printf("Mathematics achievement:%d,Mathematics achievement range[0--100]:",p->data.math);
        scanf("%d",&p->data.math);
        getchar();
        printf("English achievement:%d,English achievement range[0--100]:",p->data.english);
        scanf("%d",&p->data.english);
        getchar();


        p->data.total=p->data.english+p->data.math+p->data.c;
        p->data.ave=p->data.total/3;
        printf("====>Modify successfully\n");
        saveflag=1;
        system("pause");
        Menu();
    }
    else printf("Can't find\n");
}
void Wrong()
{
    printf("There are no student records\n");
}
void Tongji(link l)
{
    Node *pa,*pb,*pc,*q,*head,*r;
    int english,math,c;
    english=math=c=0;
    head=l->next;
    if(head==NULL)
    {
        printf("No student information can be recorded\n");
        system("pause");
        Menu();
        return ;
    }
    pa=pb=pc=q=r=head;
    while(r)
    {
        if(r->data.english<60)english++;
        if(r->data.math<60)math++;
        if(r->data.c<60)c++;
        r=r->next;
    }
    while(head!=NULL)
    {
        if(head->data.english>=pc->data.english)
            pc=head;
        if(head->data.math>=pb->data.math)
            pb=head;
        if(head->data.c>=pa->data.c)
            pa=head;
        if(head->data.total>=q->data.total)
            q=head;
        head=head->next;
    }
    printf("------Statistical results--------------------\n");
    printf("clanguage achievement<60:%d<ren>\n",c);
    printf("Mathematics achievement<60:%d<ren>\n",math);
    printf("English achievement<60:%d<ren>\n",english);
    printf("-----------------------------------\n");
    printf("Students with the highest total score:%s %d\n",q->data.name,q->data.total);
    printf("Students with the highest marks in English:%s %d\n",pc->data.name,pc->data.english);
    printf("Mathematics is the highest student:%s %d\n",pb->data.name,pb->data.math);
    printf("CThe highest spoken language students:%s %d\n",pa->data.name,pa->data.c);
    system("pause");
    Menu();

}
void Sort(link l)
{
    link ll;
    int last=1;
    Node *p,*q,*r,*t;
    ll=new Node;
    ll->next=NULL;
    if(l->next==NULL)
    {
        printf("No student can sort\n");
        return ;
    }
    p=l->next;
    while(p)
    {
        r=new Node;
        r->data=p->data;
        r->next=NULL;

    q=ll;
    while(q->next!=NULL&&q->next->data.total>=p->data.total)
    {
        q=q->next;
    }
    if(q->next==NULL)
    {
        q->next=r;
    }
    else
    {
        r->next=q->next;
        q->next=r;
    }
    p=p->next;
    }
    free(l);
    l->next=ll->next;
    t=new Node;
    t=l;
    if(t){
            t->data.rank=1;
            t=t->next;
    }
    while(t)
    {
        t->data.rank=last++;
        t=t->next;
    }
    Disp(l);
    system("pause");
    Menu();
}
void Insert(link l)
{
    Node *p,*q;
    char number[20];
    p=new Node;
    printf("Please enter the insertion location after the student number:");
    scanf("%s",number);
    printf("Enter new student number:");
    scanf("%s",p->data.number);
    printf("name:");
    scanf("%s",p->data.name);
    getchar();
    printf("cLanguage achievement range[0--100]:");
    scanf("%d",&p->data.c);
    getchar();
    printf("Mathematics achievement range[0--100]:");
    scanf("%d",&p->data.math);
    getchar();
    printf("English achievement range[0--100]:");
    scanf("%d",&p->data.english);
    p->data.total=p->data.english+p->data.c+p->data.math;
    p->data.ave=p->data.total/3;
    q=Locate(l,number,"number");

    if(q)
    {
        p->next=q->next;
        q->next=p;
        Disp(l);
        system("pause");
        Menu();
    }
    else printf("Cannot insert\n");
}
int main()
{
    link l;
    Node *p,*q;
    int choose,count=0;
    char ch,t,jixu;
    FILE *fp;
    l=new Node;
    l->next=NULL;
    q=l;
    fp=fopen("D:\\student","rb");

    if(fp==NULL)
    {
        printf("The file does not exist. Do you want to create it?Y or N");
        scanf("%c",&t);
        if(t=='Y'||t=='y')
        {
            fp=fopen("D:\\student","wb");
            printf("File successfully created\n");
            printf("Display%d bar data\n",count);
        }
        else exit(0);
    }

    while(!feof(fp))
    {
        p=new node;
        if(fread(p,sizeof(Node),1,fp))
        {
            p->next=NULL;
            q->next=p;
            q=p;
            count++;
        }
    }
    fclose(fp);
    Menu();
    while(1)
    {
        printf("Please enter your options(0--9):");
        scanf("%d",&choose);
        if(choose==0)
        {
            if(saveflag==1)
            {
                getchar();
                printf("Save?y/n:");
                scanf("%c",&ch);
                if(ch=='y'||ch=='Y')
                Save(l);
            }
            printf("Successfully exited the system\n");
            break;
        }
        if(choose==1&&count==0)
        {
            printf("=====>There are no student records!\n");
            system("pause");

        }
        switch(choose)
        {
            case 0:Menu();
            case 1:Add(l);break;
            case 2:Del(l);break;
            case 3:Qur(l);break;
            case 4:Modify(l);break;
            case 5:Insert(l);break;
            case 6:Tongji(l);break;
            case 7:Sort(l);break;
            case 8:Save(l);break;
            case 9:Disp(l);break;
            default :Wrong();
        }
    }
    return 0;

}
