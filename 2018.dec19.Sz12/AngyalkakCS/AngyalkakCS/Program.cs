using System;
using System.Collections.Generic;
using System.Text;

namespace AngyalkakCS
{
    class Pakk : IComparable<Pakk>
    {
        public int ev;
        public List<Nevek> nevek;

        public Pakk(int ev)
        {
            this.ev = ev;
            this.nevek = new List<Nevek>();
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append(this.ev).Append(":");
            foreach (Nevek n in nevek)
            {
                if (nevek[nevek.Count - 1].nev == n.nev)
                {
                    sb.Append(n.ToString());
                }
                else
                {
                    sb.Append(n.ToString()).Append(",");
                }
            }
            return sb.ToString();
        }

        public int CompareTo (Pakk o)
        {
            if (this.ev > o.ev)
            {
                return 1;
            }
            if (this.ev < o.ev)
            {
                return -1;
            }
            return 0;
        }
    }
    class Nevek : IComparable<Nevek>
    {
        public string nev;

        public Nevek(string nev)
        {
            this.nev = nev;
        }

        public override string ToString()
        {
            return this.nev;
        }

        public int CompareTo(Nevek o)
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
    }

    class Program
    {
        static void Main(string[] args)
        {
            String input;
            List<Pakk> pakkok = new List<Pakk>();
            Pakk tmp;
            String[] be;
            String[] be2;
            while ((input = Console.ReadLine()) != null && input != "")
            {
                be = input.Split(':');
                be2 = be[1].Split(',');
                foreach (string s in be2)
                {
                    tmp = null;
                    foreach (Pakk p in pakkok)
                    {
                        if (p.ev == Convert.ToInt32(s))
                        {
                            tmp = p;
                            break;
                        }
                    }
                    if (tmp == null)
                    {
                        pakkok.Add(new Pakk(Convert.ToInt32(s)));
                        pakkok[pakkok.Count - 1].nevek.Add(new Nevek(be[0]));
                    }
                    else
                    {
                        tmp.nevek.Add(new Nevek(be[0]));
                    }
                }
            }
            pakkok.Sort();
            foreach (Pakk p in pakkok)
            {
                p.nevek.Sort();
            }
            foreach (Pakk p in pakkok)
            {
                Console.WriteLine(p);
            }
        }
    }
}
