using System;
using System.Collections.Generic;
using System.Linq;

namespace Mozisztarok
{
    class Film : IComparable<Film>
    {
        int year;
        string name;

        public Film(int year, string name)
        {
            this.year = year;
            this.name = name;
        }

        public override string ToString()
        {
            return year + ": " + name;
        }
        public int CompareTo(Film o)
        {
            if(this.year > o.year)
            {
                return 1;
            }
            if (this.year < o.year)
            {
                return -1;
            }
            if (this.name.CompareTo(o.name) > 0)
            {
                return 1;
            }
            if (this.name.CompareTo(o.name) < 0)
            {
                return -1;
            }
            return 0;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            IDictionary<string, ISet<Film>> dict = new SortedDictionary<string, ISet<Film>>();
            string be;
            while((be = Console.ReadLine())!=null){
                string[] token = be.Split(':');
                string[] token2 = token[1].Split(',');
                //string[] token3 = token[0].Split(" (");
                //string[] token4 = token3[1].Split(')');
                int seged = 0;
                string seged1 = token[0];
                for (int i = 0; i<token[0].Length; i++)
                {
                    if (seged1[i].Equals(' '))
                    {
                        seged = i;
                    }
                }
                string subs = seged1.Substring(seged+2, 4);
                string film = seged1.Substring(0, seged1.Length - 7);
                foreach(String s in token2)
                {
                    ISet<Film> tmp;
                    bool istmp = dict.TryGetValue(s, out tmp);
                    if (istmp == false)
                    {
                        tmp = new SortedSet<Film>();
                        dict.Add(s, tmp);
                    }
                    else
                    {
                        tmp = dict[s];
                    }
                    tmp.Add(new Film(int.Parse(subs), film));
                }
            }
            var sortedDict = from entry in dict orderby entry.Value.Count descending select entry;
            foreach(var entry in sortedDict)
            {
                Console.WriteLine(entry.Key);
                foreach(var foo in entry.Value)
                {
                    Console.WriteLine(foo);
                }
            }
        }
    }
}
