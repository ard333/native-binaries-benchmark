#!/bin/bash
psql -t -P "footer=off" postgresql://${POSTGRESQL_USERNAME}:${POSTGRESQL_PASSWORD}@${POSTGRESQL_HOST} << EOF
       select count(client_addr) from pg_stat_activity where datname = 'native_binaries_benchmark';
EOF
