package org.dork.ledger

import org.springframework.http.HttpStatus
import java.util.HashMap

class R : HashMap<String, Any>() {
    init {
        put("code", 0)
        put("msg", "success")
    }

    companion object {
        private val serialVersionUID = 1L

        fun error(msg: String): R {
            return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg)
        }

        @JvmOverloads
        fun error(code: Int = HttpStatus.INTERNAL_SERVER_ERROR.value(), msg: String = "未知异常，请联系管理员"): R {
            val r = R()
            r["code"] = code
            r["msg"] = msg
            return r
        }

        fun ok(msg: String): R {
            val r = R()
            r["msg"] = msg
            return r
        }

        fun ok(map: Map<String, Any>): R {
            val r = R()
            r.putAll(map)
            return r
        }

        fun ok(): R {
            return R()
        }
    }
}
