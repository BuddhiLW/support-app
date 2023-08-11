(ns caiu.db
  (:require
   [clojure.string :as str]))

(def default-db
  {:nav {:pagina-ativa :caiu}
   :auth {:uid nil}
   :errors  {}
   :faq {:topicos
         {:t-1 {:id-topico :t-1
                :titulo "t-1 Título do Tópico 1"
                :subtopicos
                {:p-1 {:id-pergunta :p-1
                       :pergunta "t-1 Pergunta subtopíca 1"
                       :resposta "t-1 Resposta subtópica 1"}
                 :p-2 {:id-pergunta :p-2
                       :pergunta "t-1 Pergunta subtópica 2"
                       :resposta "t-1 Resposta subtópica 2"}}}
          :t-2 {:id-topico :t-2
                :titulo "t-2 Título do Tópico 2"
                :subtopicos
                {:p-1 {:id-pergunta :p-1
                       :pergunta "t-2 Pergunta subtopíca 1"
                       :resposta "t-2 Resposta subtópica 1"}
                 :p-2 {:id-pergunta :p-2
                       :pergunta "t-2 Pergunta subtópica 2"
                       :resposta "t-2 Resposta subtópica 2"}}}
          :t-3 {:id-topico :t-3
                :titulo "t-3 Título do Tópico 3"
                :subtopicos
                {:p-1 {:id-pergunta :p-1
                       :pergunta "t-3 p-1 - Pergunta subtopíca 1"
                       :resposta "t-3 r-1 - Resposta subtópica 1"}
                 :p-2 {:id-pergunta :p-2
                       :pergunta "t-3 p-2 - Pergunta subtópica 2"
                       :resposta "t-3 r-2 - Resposta subtópica 2"}}}}
         :ativo {:topico :t-1
                 :pergunta :p-1}}})

;; dev-mode -> false, para builds de produção
;; DESCRIÇÃO: refere-se a se usar ou não o servidor local
(def dev-mode true)
(def local-node-server "http://localhost:8001")

(def api-url
  (if dev-mode
    local-node-server
    (-> js/window
        .-location
        .-origin
        (str/split #"#")
        first)))
