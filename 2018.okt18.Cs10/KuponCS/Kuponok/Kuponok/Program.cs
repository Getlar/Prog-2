using System;
using System.Collections.Generic;

namespace Kuponok
{
    class Program
    {
        class Kupon : IComparable<Kupon>
        {
            public string boltNeve;
            public string termekNeve;
            public int kedvezmeny;

            public Kupon(string boltNeve, string termekNeve, int kedvezmeny)
            {
                this.boltNeve = boltNeve;
                this.termekNeve = termekNeve;
                this.kedvezmeny = kedvezmeny;
            }

            public override string ToString()
            {
                return termekNeve + " (" + boltNeve + "): " + kedvezmeny + "%";
            }
            public int CompareTo(Kupon o)
            {
                if (this.kedvezmeny > o.kedvezmeny)
                {
                    return -1;
                }
                if (this.kedvezmeny < o.kedvezmeny)
                {
                    return 1;
                }
                if (this.boltNeve.CompareTo(o.boltNeve) > 0)
                {
                    return 1;
                }
                if (this.boltNeve.CompareTo(o.boltNeve) < 0)
                {
                    return -1;
                }
                if (this.termekNeve.CompareTo(o.termekNeve) > 0)
                {
                    return 1;
                }
                if (this.termekNeve.CompareTo(o.termekNeve) < 0)
                {
                    return -1;
                }
                return 0;
            }
        }
        class ComparingKupons : IComparer<Kupon>
        {
            public int Compare(Kupon o1, Kupon o2)
            {
                if (o1.boltNeve.CompareTo(o2.boltNeve) > 0)
                {
                    return 1;
                }
                if (o1.boltNeve.CompareTo(o2.boltNeve) < 0)
                {
                    return -1;
                }
                if (o1.kedvezmeny > o2.kedvezmeny)
                {
                    return -1;
                }
                if (o1.kedvezmeny < o2.kedvezmeny)
                {
                    return 1;
                }
                if (o1.termekNeve.CompareTo(o2.termekNeve) > 0)
                {
                    return 1;
                }
                if (o1.termekNeve.CompareTo(o2.termekNeve) < 0)
                {
                    return -1;
                }
                return 0;
            }
        }
       
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Kupon[] kuponok = new Kupon[n];
            for (int i = 0; i < kuponok.Length; i++)
            {
                string sor = Console.ReadLine();
                string[] be = sor.Split(';');
                kuponok[i] = new Kupon(be[0], be[1], int.Parse(be[2]));
            }
            Array.Sort(kuponok);
            foreach (Kupon k in kuponok)
            {
                Console.WriteLine(k);
            }
            Console.WriteLine();
            ComparingKupons kupi = new ComparingKupons();
            Array.Sort(kuponok, kupi);
            foreach (Kupon k in kuponok)
            {
                Console.WriteLine(k);
            }
        }
    }
}
