using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Primvalogatas
{
    class Program
    {
        static TextReader input = Console.In;
        static void Main(string[] args)
        {
            if (args.Any())
            {
                var path = args[0];
                if (File.Exists(path))
                {
                    input = File.OpenText(path);
                }
            }
            string line;
            while ((line = input.ReadLine()) != null)
            {
                ISet<int> halmaz = new SortedSet<int>();
                string[] be = line.Split(' ');
                foreach(string s in be)
                {
                    int akt = int.Parse(s);
                    bool prime = true;
                    for (int i = 2; i <= akt/2; i++)
                    {
                        if (akt % i == 0)
                        {
                            prime = false;
                        }
                    }
                    if (prime == true && akt!= 1)
                    {
                        halmaz.Add(akt);
                    }
                }
                string p = string.Join(" ,", halmaz);
                Console.WriteLine(p);
            }
        }
    }
}
