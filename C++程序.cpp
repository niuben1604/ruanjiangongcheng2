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
	cout<<"�����ʦ����N: ";
	cin>>N;
	teacher *t;
	t=new teacher [N];
	for(i=1;i<=N;i++)
	{
		cout<<"�����"<<i<<"λ��ʦ����Ϣ(��MŮF): "<<endl;
		cout<<"����: ";
		cin>>t[i-1].num;
		cout<<"����: ";
		cin>>t[i-1].name;
		cout<<"�Ա�: ";
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