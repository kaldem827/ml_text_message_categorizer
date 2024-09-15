package org.elvin.utils;

public class Constants {
    public static String[] stopwords = {
            "a", "à", "ainda", "alem", "algum", "alguma", "algumas", "alguns", "alguém", "ampla", "amplas", "amplo", "amplos", "ante", "antes",
            "ao", "aos", "apenas", "apoio", "após", "aquela", "aquelas", "aquele", "aqueles", "aquilo", "as", "assim", "atrás", "através",
            "até", "bastante", "bem", "boa", "boas", "bom", "bons", "breve", "c", "cada", "caminho", "catorze", "cedo", "cento", "certamente",
            "certeza", "cima", "cinco", "coisa", "coisas", "com", "como", "conselho", "contra", "contudo", "custa", "cá", "da", "daquela",
            "daquelas", "daquele", "daqueles", "dar", "das", "de", "debaixo", "demais", "dentro", "depois", "desde", "desligado", "desta",
            "destas", "deste", "destes", "deve", "devem", "dez", "dezanove", "dezasseis", "dezassete", "dezoito", "dia", "diante", "direita",
            "diz", "dizer", "do", "dois", "dos", "doze", "duas", "durante", "dá", "dão", "e", "ela", "elas", "ele", "eles", "em", "embora",
            "enquanto", "entao", "entre", "era", "eram", "essa", "essas", "esse", "esses", "esta", "está", "estáo", "estamos", "estao", "estar",
            "estará", "estas", "estava", "estavam", "este", "esteja", "estejam", "estes", "esteve", "estive", "estivemos", "estiveram",
            "estiveste", "estivestes", "estou", "eu", "exemplo", "f", "faz", "fazeis", "fazem", "fazemos", "fazer", "fazes", "fazia",
            "faço", "fez", "fim", "final", "foi", "fomos", "for", "fora", "foram", "forma", "foste", "fostes", "fui", "geral", "grande",
            "grandes", "grupo", "há", "haja", "hajam", "hoje", "houve", "houvemos", "houver", "houvera", "houveram", "houverei", "houverem",
            "houveremos", "houveria", "houveriam", "houvermos", "houvesse", "houvessem", "isso", "isto", "já", "la", "lado", "lhe", "lhes",
            "ligado", "logo", "longe", "lugar", "lá", "mais", "mal", "mas", "me", "mediante", "meio", "menor", "menos", "mesma", "mesmas",
            "mesmo", "mesmos", "meu", "meus", "mil", "minha", "minhas", "momento", "muito", "muitos", "máximo", "mês", "na", "nada", "nao",
            "naquela", "naquelas", "naquele", "naqueles", "nas", "nem", "nenhum", "nessa", "nessas", "nesse", "nesses", "nesta", "nestas",
            "neste", "nestes", "ninguém", "no", "noite", "nos", "nossa", "nossas", "nosso", "nossos", "nova", "novas", "nove", "novo", "novos",
            "num", "numa", "nunca", "não", "nós", "o", "os", "ou", "outra", "outras", "outro", "outros", "para", "parece", "parte", "partir",
            "paucas", "pela", "pelas", "pelo", "pelos", "per", "perante", "perto", "pode", "podem", "poder", "poderá", "podia", "pois", "ponto",
            "pontos", "por", "porque", "porquê", "pouca", "pouco", "poucos", "povo", "primeiro", "primeiros", "promeiro", "própria", "próprias",
            "próprio", "próprios", "próxima", "próximo", "próximos", "puderam", "quais", "quaisquer", "qual", "qualquer", "quando", "quanto",
            "quantos", "quase", "que", "quem", "quer", "quereis", "querem", "queremas", "queres", "quero", "questão", "quieto", "quinta",
            "quintas", "quinto", "quintos", "quê", "raramente", "raro", "sabe", "sabem", "saber", "se", "segunda", "segundas", "segundo",
            "segundos", "sei", "seis", "seja", "sejam", "sem", "sempre", "sendo", "ser", "será", "serão", "serei", "seremos", "seria", "seriam",
            "sermos", "ses", "seu", "seus", "si", "sido", "sim", "sistema", "sob", "sobre", "sois", "somos", "sou", "sua", "suas", "são",
            "sétima", "sétimo", "tal", "tais", "também", "tampouco", "tanta", "tantas", "tanto", "tão", "tarde", "te", "tem", "temos", "tempo",
            "tendes", "tendo", "tenha", "tenham", "tenho", "tens", "ter", "terá", "terão", "terei", "teremos", "teria", "teriam", "termos",
            "teu", "teus", "teve", "tipo", "tive", "tivemos", "tiver", "tivera", "tiveram", "tiverem", "tivermos", "tivesse", "tivessem",
            "toda", "todas", "todavia", "todo", "todos", "trabalhar", "trabalho", "treze", "três", "tu", "tua", "tuas", "tudo", "tão",
            "um", "uma", "umas", "uns", "usa", "usar", "vai", "vais", "valor", "veja", "ver", "verdade", "verdadeiro", "vindo", "vinte",
            "você", "vocês", "vos", "vossa", "vossas", "vosso", "vossos", "vários", "vão", "vêm", "vós", "zero", "à", "às", "área", "áreas",
            "é", "éramos"
    };

   public static class Pair<T, U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }

}

