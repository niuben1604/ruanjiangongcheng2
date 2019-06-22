#include<iostream>
#include<fstream>
#include<string>
using namespace std;
struct teacher
{
	int num;
	string name;
	char sex;
};
int main()
{
	int i,N;
	ofstream file("teacher.dat",ios::binary);
	if(!file)
	{
		cerr<<"Error!"<<endl;
		abort();
	}
	cout<<"输入教师人数N: ";
	cin>>N;
	teacher *t;
	t=new teacher [N];
	for(i=1;i<=N;i++)
	{
		cout<<"输入第"<<i<<"位教师的信息(男M女F): "<<endl;
		cout<<"工号: ";
		cin>>t[i-1].num;
		cout<<"姓名: ";
		cin>>t[i-1].name;
		cout<<"性别: ";
		cin>>t[i-1].sex;
	}
	cout<<"\t\t"<<"Num\t"<<"Name\t"<<"Sex\t"<<endl;
	for(i=1;i<=N;i++)
	{
		cout<<"Teacher"<<i<<'\t'<<t[i-1].num<<'\t'<<t[i-1].name<<'\t'<<t[i-1].sex<<endl;
		file<<"Teacher"<<i<<'\t'<<t[i-1].num<<'\t'<<t[i-1].name<<'\t'<<t[i-1].sex<<endl;
	}
	file.close();
	delete []t;
	return 0;
}