using System;

namespace Foszereplozes
{

    class Konyvek : IComparable<Konyvek>
    {
        private string nev;
        private int hanyfoszerep;

        public Konyvek(string nev, int hanyfoszerep)
        {
            this.Nev = nev;
            this.Hanyfoszerep = hanyfoszerep;
        }

        public int CompareTo(Konyvek o)
        {
            if (string.Compare(this.nev, o.nev, StringComparison.Ordinal) > 0)
            {
                return 1;
            }
            if (string.Compare(this.nev, o.nev, StringComparison.Ordinal) < 0)
            {
                return -1;
            }
            return 0;
        }

        public string Nev { get => nev; set => nev = value; }
        public int Hanyfoszerep { get => hanyfoszerep; set => hanyfoszerep = value; }
    }
    class Program
    {
        static void Main(string[] args)
        {
            string[] be = Console.ReadLine().Split(' ');
            int hany = Convert.ToInt32(be[0]);
            int max = Convert.ToInt32(be[1]);
            Konyvek[] konyvek = new Konyvek[hany];
            for(int i = 0; i < konyvek.Length; i++)
            {
                string[] separator = { ":", "," };
                string[] be2 = Console.ReadLine().Split(separator, StringSplitOptions.RemoveEmptyEntries);
                konyvek[i] = new Konyvek(be2[0], be2.Length - 1);
            }
            Array.Sort(konyvek);
            for (int i = 0; i < konyvek.Length; i++)
            {
                if (konyvek[i].Hanyfoszerep == max)
                {
                    Console.WriteLine(konyvek[i].Nev);
                }
            }
        }
    }
}
