using System;
using System.Collections.Generic;

namespace Angyalkak
{
    class Program
    {
        class Nevek : IComparable<Nevek>
        {
            string nev;

            public Nevek(string nev)
            {
                this.nev = nev;
            }

            public override string ToString()
            {
                return nev;
            }
            public int CompareTo(Nevek o)
            {
                return this.nev.CompareTo(o.nev);
            }
        }
        
        static void Main(string[] args)
        {
            IDictionary<int, ISet<Nevek>> map = new SortedDictionary<int, ISet<Nevek>>();
            string be;
            while ((be = Console.ReadLine()) != null)
            {
                string[] befele = be.Split(':');
                string[] evek = befele[1].Split(',');
                foreach(string s in evek)
                {
                    int a = Convert.ToInt32(s);
                    ISet<Nevek> entry;
                    bool isentry = map.TryGetValue(a, out entry);
                    if (isentry == false)
                    {
                        entry = new SortedSet<Nevek>();
                        map.Add(a, entry);
                    }
                    else
                    {
                        entry = map[a];
                    }
                    entry.Add(new Nevek(befele[0]));
                }
            }
            foreach(var entry in map)
            {
                string s = string.Join(",", entry.Value);
                Console.WriteLine(entry.Key + ":" + s);
            }
        }
    }
}
